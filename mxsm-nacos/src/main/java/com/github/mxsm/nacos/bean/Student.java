package com.github.mxsm.nacos.bean;

import com.github.mxsm.nacos.annotation.EnableNacosConfig;
import com.github.mxsm.nacos.annotation.NacosProperties;
import com.github.mxsm.nacos.annotation.NacosValue;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author mxsm
 * @Date 2019/8/3 21:45
 * description:
 */
@Component
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848", namespace = "1ef58b42-2e3c-4c11-9698-ce8e9c8e4e63"))
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
