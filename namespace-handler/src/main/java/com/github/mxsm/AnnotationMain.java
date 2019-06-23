package com.github.mxsm;

import com.github.mxsm.process.MxsmBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.github.mxsm");
        System.out.println(applicationContext.getBean(MxsmBeanPostProcessor.class));
    }

}
