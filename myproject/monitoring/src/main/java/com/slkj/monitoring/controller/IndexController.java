package com.slkj.monitoring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "/indexs";
    }

    @RequestMapping("/success")
    public String success(){
        return "/success";
    }
    @RequestMapping("/changewd")
    public String changewd(){
        return "/change";
    }

}
