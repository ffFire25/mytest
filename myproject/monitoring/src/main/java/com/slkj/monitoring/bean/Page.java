package com.slkj.monitoring.bean;

import lombok.Data;

/**
 * 封装分页类
 */
@Data
public class Page {
    //每页显示数量
    private int limit;
    //页码
    private int page;
    //sql语句起始索引
    private int offset;
}
