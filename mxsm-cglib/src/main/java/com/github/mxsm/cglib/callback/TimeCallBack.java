package com.github.mxsm.cglib.callback;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author mxsm
 * @Date 2019/8/3 15:35
 * description:
 */
public class TimeCallBack implements MethodInterceptor {

    /**
     * All generated proxied methods call this method instead of the original method.
     * The original method may either be invoked by normal reflection using the Method object,
     * or by using the MethodProxy (faster).
     *
     * @param obj    "this", the enhanced object
     * @param method intercepted Method
     * @param args   argument array; primitive types are wrapped
     * @param proxy  used to invoke super (non-intercepted method); may be called
     *               as many times as needed
     * @return any value compatible with the signature of the proxied method. Method returning void will ignore this value.
     * @throws Throwable any exception may be thrown; if so, super method will not be invoked
     * @see MethodProxy
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("StartTime=[" + System.currentTimeMillis() + "]");
        Object result = proxy.invokeSuper(obj,args);
        System.out.println("result="+result);
        System.out.println("EndTime=[" + System.currentTimeMillis() + "]");

        return result;
    }
}
