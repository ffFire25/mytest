package com.slkj.monitoring.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int uid;
    private String userName;
    private String passWord;
    private Date beginTime;
    private Date endTime;
}
