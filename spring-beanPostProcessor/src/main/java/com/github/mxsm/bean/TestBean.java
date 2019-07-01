package com.github.mxsm.bean;

import com.github.mxsm.annotation.MxsmValue;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/6/27 23:42
 * description:
 */
@Component
public class TestBean {

    @MxsmValue("test")
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
