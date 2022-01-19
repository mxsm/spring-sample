package com.github.mxsm;

import com.github.mxsm.bean.MxsmBeanTest;
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
        MxsmBeanTest test = context.getBean("test", MxsmBeanTest.class);
        System.out.println(test);
        MxsmBeanTest bean = context.getBean(MxsmBeanTest.class);
        System.out.println(bean);
        System.out.println(test==bean);
    }
}
