package com.github.mxsm.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.io.File;
import java.io.FileReader;
import java.io.PushbackInputStream;
import java.lang.reflect.Method;

/**
 * @author mxsm
 * @Date 2019/8/1 23:01
 * description:
 */
public class EnhancerForSampleClassApplication {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(A.class);
        enhancer.setCallback(new MxsmPoxy());
        A a = (A)enhancer.create();
        a.aaa("bbb");
    }

   public interface A{

        public void aaa(String aaa);

   }

   public static  class MxsmPoxy implements MethodInterceptor{

       @Override
       public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

           System.out.println( method.getName());
           System.out.println(args[0]);

           return null;
       }
   }

}
