package com.github.mxsm.nacos;

import com.github.mxsm.nacos.annotation.NacosValue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author mxsm
 * @Date 2019/7/27 23:51
 * description:
 */
@Component
public class BeanTest {

    @NacosValue(dataId = "mxsm", group = "nacos")
    private String name;

    @PostConstruct
    public void init(){
        System.out.println("----------++++++---------"+name);
    }
}
