package com.ioc.model;

/**
 * Created by hengluwen on 16/8/3.
 */
public class User {

    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.userName + "/");
        sb.append(this.password);
        return sb.toString();
    }
}
