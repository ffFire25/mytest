package com.slkj.monitoring.util;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtil {

    public static boolean uploadFile(MultipartFile file, String filePath, String fileName) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String targetFilePath = filePath + "/"+ sdf.format(new Date());
        File targetFile = new File(targetFilePath);
        //判断文件父目录是否存在
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdir();
        }
        //判断文件是否存在
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String realPath = targetFilePath + "/" + fileName;
        File realFile = new File(realPath);
        try {
            //保存文件
            file.transferTo(realFile);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
//        FileOutputStream out = new FileOutputStream(filePath + fileName);
//        out.write(file);
//        out.flush();
//        out.close();
    }

    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 生成新的文件名
     * @param fileName
     * @return
     */
    public static String renameToUUID(String fileName) {
        return UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 用作download时对respoonse的处理
     * @param request
     * @param response
     * @param filePath
     * @return
     */
    public static HttpServletResponse downloadHandler(HttpServletRequest request,HttpServletResponse response, String filePath){
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        File file = new File(filePath);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        FileInputStream fis=null;
        try {
            fis = new FileInputStream(file);
            IOUtils.copy(fis, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;

    }


    public static String upload(MultipartFile file )  throws IOException {
        String suffix = "";
        String fileOrgName=file.getOriginalFilename();
        //之后做空值判断
        int index = fileOrgName.lastIndexOf(".");
        if(index!=-1){
            suffix = fileOrgName.substring(index);
        }
        String fileName= UUID.randomUUID().toString().replaceAll("-","") + suffix;
        try(InputStream inputStream=file.getInputStream(); FileOutputStream fileOutputStream=new FileOutputStream(fileName)){
            byte[] bytes=new byte[1024];
            int len=0;
            while((len=inputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,len);
            }
            fileOutputStream.flush();
        }

        return AliyunOssUtils.uploadFile(new File(fileName));
    }

    public static String uploadImg(MultipartFile file,int width,int height )  throws IOException {

        String suffix = "";
        String fileOrgName=file.getOriginalFilename();
        int index = fileOrgName.lastIndexOf(".");
        if(index!=-1){
            suffix = fileOrgName.substring(index);
        }
        String fileName= UUID.randomUUID().toString().replaceAll("-","") + suffix;

        Thumbnails.of(file.getInputStream()).size(width, height ).toFile(fileName);
        return AliyunOssUtils.uploadFile(new File(fileName));
    }
}

