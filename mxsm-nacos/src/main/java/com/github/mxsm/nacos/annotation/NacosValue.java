package com.github.mxsm.nacos.annotation;

import com.github.mxsm.nacos.enums.NacosValueType;

import java.lang.annotation.*;

/**
 * @author mxsm
 * @Date 2019/7/27 23:43
 * description:nacos值的注解
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NacosValue {

    boolean required() default false;

    //值的类型
    NacosValueType valueType() default NacosValueType.TEXT;

    //data id
    String dataId();

    //group
    String group();
}
