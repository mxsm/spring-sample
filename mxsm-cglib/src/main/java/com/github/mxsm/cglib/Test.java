package com.github.mxsm.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author mxsm
 * @Date 2020/12/11
 */
public class Test {

    public static void main(String[] args) {

        InvocationHandler handler = (proxy, method, args1) -> {


            System.out.println(method);

            return null;
        };

        Helleo helleo = (Helleo)Proxy.newProxyInstance(Helleo.class.getClassLoader(), new Class[]{Helleo.class}, handler);
        helleo.morning("1111");

    }

    interface  Helleo{
        void morning(String name);
    }
}
