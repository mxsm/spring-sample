package com.github.mxsm.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * BeanPostProcessor接口中的方法
     * 在Bean的自定义初始化方法之前执行
     * Bean对象已经存在了
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println(">>postProcessBeforeInitialization");
        return bean;
    }

    /**
     * BeanPostProcessor接口中的方法
     * 在Bean的自定义初始化方法执行完成之后执行
     * Bean对象已经存在了
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("<<postProcessAfterInitialization");
        return bean;
    }

    /**
     * InstantiationAwareBeanPostProcessor中自定义的方法
     * 在方法实例化之前执行  Bean对象还没有
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("--->postProcessBeforeInstantiation");
        return null;
    }

    /**
     * InstantiationAwareBeanPostProcessor中自定义的方法
     * 在方法实例化之后执行  Bean对象已经创建出来了
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("<---postProcessAfterInstantiation");
        return true;
    }

    /**
     * InstantiationAwareBeanPostProcessor中自定义的方法
     * 可以用来修改Bean中属性的内容
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
                                                    String beanName) throws BeansException {
        System.out.println("<---postProcessPropertyValues--->");
        return pvs;
    }
}