package com.slkj.monitoring.service.serviceImpl;

import com.slkj.monitoring.bean.PointDo;
import com.slkj.monitoring.dao.PointDao;
import com.slkj.monitoring.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PointServiceImpl implements PointService {
    @Autowired
    PointDao pointDao;
    @Override
    public List<PointDo> getPointList(Map<String, Object> map) {
        return pointDao.getPointList(map);
    }

    @Override
    public int getPointNum(Map<String, Object> map) {
        return pointDao.getPointNum(map);
    }
}
