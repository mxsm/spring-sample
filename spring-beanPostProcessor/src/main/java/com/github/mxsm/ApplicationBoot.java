package com.github.mxsm;

import com.github.mxsm.bean.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class ApplicationBoot
{
    public static void main( String[] args ) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        TestBean testBean = applicationContext.getBean(TestBean.class);
        System.out.println(testBean.getName());

    }
}
