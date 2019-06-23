package com.github.mxsm.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MxsmBeanPostProcessor   implements InstantiationAwareBeanPostProcessor {



    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(1+"------");

        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(2+"------");
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println(3+"------");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println(4+"------");
        return false;
    }
}
