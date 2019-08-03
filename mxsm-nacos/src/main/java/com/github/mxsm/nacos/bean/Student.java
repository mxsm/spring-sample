package com.github.mxsm.nacos.bean;

import com.github.mxsm.nacos.annotation.NacosValue;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/8/3 21:45
 * description:
 */
@Component
public class Student {

    @NacosValue(dataId = "name",group = "mxsm",refresh = true)
    private String name;

    @NacosValue(dataId = "className",group = "mxsm",refresh = true)
    private String className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
