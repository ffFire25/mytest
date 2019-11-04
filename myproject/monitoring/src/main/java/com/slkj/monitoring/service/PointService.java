package com.slkj.monitoring.service;

import com.slkj.monitoring.bean.PointDo;

import java.util.List;
import java.util.Map;

public interface PointService {
    List<PointDo> getPointList(Map<String, Object> map);

    int getPointNum(Map<String, Object> map);
}
