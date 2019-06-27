package com.github.mxsm;

import com.github.mxsm.processor.MxsmPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.github.mxsm");

        //System.out.println(applicationContext.getBean(MxsmPostProcessor.class));
    }
}
