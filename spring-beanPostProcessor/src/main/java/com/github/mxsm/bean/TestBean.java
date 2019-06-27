package com.github.mxsm.bean;

/**
 * @author mxsm
 * @Date 2019/6/27 23:42
 * description:
 */
public class TestBean {

    private String name;

    public void init(){
        System.out.println("TestBean---init()");
        this.name = "test";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
