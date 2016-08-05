package com.ioc.dao;

import com.ioc.model.User;

/**
 * Created by hengluwen on 16/8/3.
 */
public interface UserDao {
    /**
     * add user
     * @param user
     */
    public void add(User user);

    /**
     * delete one's account
     * @param username
     */
    public void delete(String username);


}
