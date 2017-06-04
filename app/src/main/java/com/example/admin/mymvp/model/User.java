package com.example.admin.mymvp.model;

/**
 * Created by admin on 2017/5/17.
 */

public class User {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User(String zeng, String s) {
        this.name = zeng;
        this.age = s;
    }
}
