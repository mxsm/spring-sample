package com.github.mxsm.bean;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

/**
 * @author mxsm
 * @Date 2019/6/16
 */
public class ApplicationBean implements EnvironmentAware {

    private Environment environment;

    public void init(){
        System.out.println("init");
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
