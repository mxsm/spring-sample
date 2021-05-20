package com.github.mxsm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(SpringBootStrap.class,args);
       /* ClassLoader classLoader = A.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(Thread.currentThread().getContextClassLoader());
        //System.out.println(System.getProperty("java.class.path").replaceAll(";", "\n"));
        System.out.println(System.getProperty("java.ext.dirs").replaceAll(";", "\n"));*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.github.mxsm");
        System.out.println(1111);
    }
}
