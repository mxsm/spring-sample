package com.github.mxsm.annotation;

import java.lang.annotation.*;

/**
 * @author mxsm
 * @Date 2019/8/11 16:07
 * description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MxsmComponentScan {

    String[] basePackages() default {};
}
