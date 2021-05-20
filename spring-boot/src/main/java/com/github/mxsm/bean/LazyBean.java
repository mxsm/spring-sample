package com.github.mxsm.bean;

import com.github.mxsm.processor.CustomEnable;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/8/1 0:18
 * description:
 */
@Component
@CustomEnable
public class LazyBean {

    public LazyBean() {
        System.out.println(getClass().getName() + "调用构造函数");
    }
}
