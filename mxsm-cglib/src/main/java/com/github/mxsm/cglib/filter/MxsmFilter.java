package com.github.mxsm.cglib.filter;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @author mxsm
 * @Date 2019/8/3 15:45
 * description:
 */
public class MxsmFilter implements CallbackFilter {
    /**
     * Map a method to a callback.
     *
     * @param method the intercepted method
     * @return the index into the array of callbacks (as specified by {@link Enhancer#setCallbacks}) to use for the method,
     */
    @Override
    public int accept(Method method) {

        if(method.getName().equals("method1")){
            System.out.println("filter method1 ==1");
            return 1;
        }
        if(method.getName().equals("method2")){
            System.out.println("filter method2 ==2");
            return 2;
        }
        if(method.getName().equals("method3")){
            System.out.println("filter method3 ==2");
            return 2;
        }
        return 0;
    }
}
