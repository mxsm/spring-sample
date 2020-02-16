package com.github.mxsm.elasticsearch.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/2/16 16:36
 */
public class User {

    private String id;

    private String userName;

    private String address;

    private String email;

    private int age;

    private String phoneNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
