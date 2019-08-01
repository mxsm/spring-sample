package com.github.mxsm.cglib;

import com.github.mxsm.cglib.verification.SampleClass;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class EnhancerForSampleClassApplicationTest {

    @Test
    public void testFixedValueCallback(){

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((FixedValue) () -> "fixed Value");
        SampleClass proxy = (SampleClass)enhancer.create();
        assertEquals(proxy.test(null),"fixed Value");
        assertNotEquals(proxy.test(null),"Hello world!");
        assertEquals(proxy.toString(),"fixed Value");
        System.out.println(proxy.getClass().getName());
    }


    @Test
    public void testInvocationHandler(){

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((InvocationHandler) (proxy, method, args) -> {

            Class<?> clazz = method.getDeclaringClass();
            if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello cglib!";
            } else {
                throw new RuntimeException("Do not know what to do.");
            }
        });
        SampleClass proxy = (SampleClass)enhancer.create();
        assertEquals("Hello cglib!", proxy.test(null));
        assertNotEquals("Hello cglib!", proxy.toString());
    }

}