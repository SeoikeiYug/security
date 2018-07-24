package com.seoi.dto;

/**
 * @author shuaiqi
 * @create 2018-07-24 16:42
 * @desc 查询条件
 **/
public class UserQueryCondition {

    private String username;

    private int age;

    private int ageTo;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(final int ageTo) {
        this.ageTo = ageTo;
    }
}
