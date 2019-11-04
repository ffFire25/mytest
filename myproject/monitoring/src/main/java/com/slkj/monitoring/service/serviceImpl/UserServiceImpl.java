package com.slkj.monitoring.service.serviceImpl;

import com.slkj.monitoring.bean.User;
import com.slkj.monitoring.dao.UserDao;
import com.slkj.monitoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userdao;
    @Override
    public User checkUser(String userName, String passWord) {
        return userdao.checkUser(userName,passWord);
    }

    @Override
    public int save(String userName, String oldpassWord, String newpassWord) {
        return userdao.save(userName,oldpassWord,newpassWord);
    }
}
