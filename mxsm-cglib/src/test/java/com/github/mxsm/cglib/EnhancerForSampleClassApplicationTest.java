package com.github.mxsm.cglib;

import com.github.mxsm.cglib.verification.MxsmNamingPolicy;
import com.github.mxsm.cglib.verification.SampleClass;
import net.sf.cglib.proxy.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class EnhancerForSampleClassApplicationTest {

    @Test
    public void testFixedValueCallback() {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((FixedValue) () -> "fixed Value");
        SampleClass proxy = (SampleClass) enhancer.create();
        assertEquals(proxy.test(null), "fixed Value");
        assertNotEquals(proxy.test(null), "Hello world!");
        assertEquals(proxy.toString(), "fixed Value");
        System.out.println(proxy.getClass().getName());
    }


    @Test
    public void testInvocationHandler() {

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((InvocationHandler) (proxy, method, args) -> {

            //Class<?> clazz = method.getDeclaringClass();
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello cglib!";
            } else {
                throw new RuntimeException("Do not know what to do.");
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        assertEquals("Hello cglib!", proxy.test(null));
        assertNotEquals("Hello cglib!", proxy.toString());
    }

    @Test
    public void testMethodInterceptor() {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello cglib!";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        assertEquals("Hello cglib!", proxy.test(null));
        assertNotEquals("Hello cglib!", proxy.toString());
        System.out.println(proxy.hashCode());
    }

    @Test
    public void testCallbackFilter() throws Exception {
        Enhancer enhancer = new Enhancer();
        CallbackHelper helper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return (FixedValue) () -> "Hello cglib!";
                } else {
                    return NoOp.INSTANCE; // A singleton provided by NoOp.
                }
            }
        };
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter(helper);
        enhancer.setCallbacks(helper.getCallbacks());
        enhancer.setNamingPolicy(MxsmNamingPolicy.INSTANCE);
        SampleClass proxy = (SampleClass) enhancer.create();
        assertEquals("Hello cglib!", proxy.test(null));
        assertNotEquals("Hello cglib!", proxy.toString());
        System.out.println(proxy.hashCode()); // Does not throw an exception or result in an endless loop.
        System.out.println(proxy.getClass().getName());
    }

    @Test
    public void testNamingPolicy() throws Exception {
        Enhancer enhancer = new Enhancer();
        CallbackHelper helper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return (FixedValue) () -> "Hello cglib!";
                } else {
                    return NoOp.INSTANCE; // A singleton provided by NoOp.
                }
            }
        };
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter(helper);
        enhancer.setCallbacks(helper.getCallbacks());
        enhancer.setNamingPolicy(MxsmNamingPolicy.INSTANCE);
        SampleClass proxy = (SampleClass) enhancer.create();
        assertEquals("Hello cglib!", proxy.test(null));
        assertNotEquals("Hello cglib!", proxy.toString());
        assertTrue(StringUtils.contains(proxy.getClass().getName(),MxsmNamingPolicy.TAG));
    }
}