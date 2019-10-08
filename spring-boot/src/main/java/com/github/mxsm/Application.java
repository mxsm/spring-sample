package com.github.mxsm;

import com.github.mxsm.bean.WarpperBean;
import com.github.mxsm.processor.MxsmPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        /*ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.github.mxsm");

        WarpperBean warpperBean = applicationContext.getBean(WarpperBean.class);
        warpperBean.print();
        System.out.println(warpperBean.toString());*/
    }
}
