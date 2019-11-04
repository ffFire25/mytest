package com.slkj.monitoring.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装返回实体类
 */
@Data
public class Result <T>{
    //实体类集合
    private List<T> rows = new ArrayList<T>();
    //数据总条数
    private int total;
}
