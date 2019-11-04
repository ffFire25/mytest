package com.slkj.monitoring.controller;

import com.slkj.monitoring.bean.PointDo;
import com.slkj.monitoring.bean.Result;
import com.slkj.monitoring.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PointController {

@Autowired
    PointService pointService;

    @RequestMapping("/getPointList")
    public Result<PointDo> getPointList(PointDo pointDo,HttpServletRequest request) {
        Result<PointDo> result = new Result<>();
        //从session中获取用户ID
        HttpSession session = request.getSession();
        int uid = (int) session.getAttribute("uid");
        //查找用户拥有点位
        Map<String, Object> map = new HashMap<>();
        map.put("offset",pointDo.getOffset());
        map.put("limit",pointDo.getLimit());
        map.put("uid",uid);
        //查找用户拥有点位总数
        int total = pointService.getPointNum(map);
        List<PointDo> pointDoList = new ArrayList<>();
        pointDoList = pointService.getPointList(map);
        //封装返回对象
        result.setRows(pointDoList);
        result.setTotal(total);
        return result;
    }
}
