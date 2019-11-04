package com.slkj.monitoring.dao;

import com.slkj.monitoring.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    User checkUser(String userName, String passWord);

    int save(String userName, String oldpassWord, String newpassWord);

}
