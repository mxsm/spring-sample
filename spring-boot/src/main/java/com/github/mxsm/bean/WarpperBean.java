package com.github.mxsm.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/8/1 0:19
 * description:
 */
@Component
@Lazy
public class WarpperBean {

    @Autowired
    @Lazy
    private LazyBean lazyBean;

    public WarpperBean() {
        System.out.println(getClass().getName() + "调用构造函数");
    }

    public void print(){
        System.out.println(lazyBean.getClass().getName());
    }

}
