package com.slkj.monitoring.dao;

import com.slkj.monitoring.bean.PointDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PointDao {

    List<PointDo> getPointList(Map<String, Object> map);

    int getPointNum(Map<String, Object> map);
}
