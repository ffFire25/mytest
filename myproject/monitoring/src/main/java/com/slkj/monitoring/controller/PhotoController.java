package com.slkj.monitoring.controller;


import com.slkj.monitoring.bean.FileType;
import com.slkj.monitoring.bean.UploadConfig;
import com.slkj.monitoring.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Slf4j
public class PhotoController {


    @Autowired
    private UploadConfig uploadConfig;

    @RequestMapping("/upload")
    public String upload(@RequestParam("mac") String mac, @RequestParam("time") String time, @RequestParam("file") MultipartFile  file){
        if (file.isEmpty()) {
            log.info("上传文件为空");
            return "上传文件为空";
        }

            //获取文件名字
            String fileName = file.getOriginalFilename();
            //限制文件上传类型
            if(FileType.fileType(fileName)==0){
                try {
                    if(FileUtil.uploadFile(file, uploadConfig.getUploadPath(), fileName)){
                        log.info("上传文件成功"+"，机器号："+mac+"，上传时间："+time);
                        return "上传文件成功"+"，机器号："+mac+"，上传时间："+time;

                    }else {
                        log.info("上传失败");
                        return "上传失败";

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                log.info("上传文件格式不符合要求");

            }



        return "上传失败";
        }


}
