package com.slkj.monitoring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 文件存储路径配置
 */
@Component
public class UploadConfig {
    @Value("${upload.path}")
    private String uploadPath;


    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
