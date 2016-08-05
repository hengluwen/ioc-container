package com.ioc.dao.impl;

import com.ioc.dao.UserDao;
import com.ioc.model.User;

/**
 * Created by hengluwen on 16/8/3.
 */
public class UserDaoImpl implements UserDao{

    public void add(User user) {
        System.out.println("add user: " + user.toString());
    }

    public void delete(String username) {
        System.out.println("delete user,and username is" + username);
    }
}
