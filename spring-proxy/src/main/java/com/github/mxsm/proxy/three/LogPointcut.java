package com.github.mxsm.proxy.three;

import java.lang.reflect.Method;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * @author mxsm
 * @date 2021/11/26 16:17
 * @Since 1.0.0
 */
public class LogPointcut extends StaticMethodMatcherPointcut{

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return AnnotatedElementUtils.hasAnnotation(method, Log.class);
    }
}
