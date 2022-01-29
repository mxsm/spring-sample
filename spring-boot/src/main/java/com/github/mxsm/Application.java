package com.github.mxsm;

import com.github.mxsm.log.EnableLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableLog
//@EnableAspectJAutoProxy
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
       /* ClassLoader classLoader = A.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(Thread.currentThread().getContextClassLoader());
        //System.out.println(System.getProperty("java.class.path").replaceAll(";", "\n"));
        System.out.println(System.getProperty("java.ext.dirs").replaceAll(";", "\n"));*/
/*        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.github.mxsm");
        System.out.println(1111);*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.github.mxsm");
        applicationContext.getBean()
    }
}
