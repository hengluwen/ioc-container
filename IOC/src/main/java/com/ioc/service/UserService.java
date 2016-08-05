package com.ioc.service;

import com.ioc.dao.UserDao;
import com.ioc.model.User;

/**
 * Created by hengluwen on 16/8/3.
 */
public class UserService {

    private UserDao userDao;

    public void addUser(User user){
        this.userDao.add(user);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
