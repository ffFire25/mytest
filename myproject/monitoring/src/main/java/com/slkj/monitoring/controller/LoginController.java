package com.slkj.monitoring.controller;

import com.slkj.monitoring.bean.User;
import com.slkj.monitoring.service.UserService;
import com.slkj.monitoring.util.JedisClientSingle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@Slf4j
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    JedisClientSingle jedisClientSingle;


    @RequestMapping("/login")
    public String checkuser(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam ("passWord") String passWord){
        User user = userService.checkUser(userName,passWord);

        if (user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("uid", user.getUid());
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("uspassWorder", user.getPassWord());
         log.info(String.valueOf(session.getAttribute("uid")));
            return "1";
        }
        return "0";
    }
    @RequestMapping("/save")
    public String save(@RequestParam("userName") String userName, @RequestParam ("oldpassWord") String oldpassWord,@RequestParam ("newpassWord") String newpassWord) {
        int num = userService.save(userName,oldpassWord,newpassWord);
        if (num==1){
            return "1";
        }
        return "0";
    }
}

