package com.github.mxsm.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/8/1 0:18
 * description:
 */
@Component
@Lazy
public class LazyBean {

    public LazyBean() {
        System.out.println(getClass().getName() + "调用构造函数");
    }
}
