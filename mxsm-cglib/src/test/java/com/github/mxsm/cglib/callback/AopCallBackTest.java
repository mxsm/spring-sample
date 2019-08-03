package com.github.mxsm.cglib.callback;

import com.github.mxsm.cglib.filter.MxsmFilter;
import com.github.mxsm.cglib.verification.TargetObject;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import static org.junit.Assert.*;

public class AopCallBackTest {

    @Test
    public void testCallBack(){

        AopCallBack aopCallBack = new AopCallBack();
        TimeCallBack timeCallBack = new TimeCallBack();
        Callback[] callbacks = new Callback[]{NoOp.INSTANCE,aopCallBack,timeCallBack};
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(new MxsmFilter());
        TargetObject proxy = (TargetObject)enhancer.create();

        proxy.method1("1");
        proxy.method2(1);
        proxy.method3(1);
        System.out.println(proxy.toString());;

    }


}