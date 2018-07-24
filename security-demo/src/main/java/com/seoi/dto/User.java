package com.seoi.dto;

/**
 * @author shuaiqi
 * @create 2018-07-24 15:08
 * @desc 用户信息
 **/
public class User {

    private String userName;

    private String password;

    public User() {

    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
