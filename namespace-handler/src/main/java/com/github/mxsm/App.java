package com.github.mxsm;

import com.github.mxsm.process.MxsmBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //System.out.println(context.getBean("aaaa",String.class));
        context.getBean("applicationBean");
    }
}
