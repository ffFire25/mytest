package com.slkj.monitoring.bean;

import lombok.Data;

import java.util.Date;

@Data
public class PointDo extends Page {

    private int pid;
    private   String   operator ;    // '运营商',
    private   String   city;       // '地点城市',
    private   String   area ;          // '地点区域',
    private   String   community;    //  '地点小区',
    private   String   projectType;  // '项目类型',
    private   String   site;         // '点位',
    private   String   address;          //  '地址',
    private   String   state;           //  '状态',
    private   String  deviceType;        //  '设备类型',
    private   String   deviceId ;              // '设备ID',
    private   String   deviceMacAddress;    //  '设备Mac地址',
    private   int      sale ;                  // '是否销售 0表示是',
    private   int      is4G;                   //'是否4G 0表示是',
    private   Date     installationTime ;     //'安装时间',
    private   int      yearBuilt;              // '建筑年代',
    private   int      visitorsFlowrate ;      // '人流量',
    private   int      households;             //  '户数',
    private   String   occupancyRates ;    // '入住率',
    private   String   CBD;                //  '商圈',
    private   String   tabooIndustry;      //  '禁忌行业',
    private   Date     houseDeliveryDate;  // '交房时间',
    private   int      floors;             // '电梯楼层数',
}
