package com.slkj.monitoring.service;

import com.slkj.monitoring.bean.User;

public interface UserService {
    public User checkUser(String userName, String passWord);

    public int save(String userName, String oldpassWord, String newpassWord);
}
