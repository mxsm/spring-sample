package com.github.mxsm.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author mxsm
 * @date 2021/12/17 23:16
 * @Since 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private Long id;

    private String name;

    private Integer age;

    private Short sex;

    private String moblie;

    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
