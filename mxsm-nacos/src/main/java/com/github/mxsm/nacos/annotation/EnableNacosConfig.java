package com.github.mxsm.nacos.annotation;

import com.github.mxsm.nacos.beanfactoryprocessor.NacosBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author mxsm
 * @Date 2019/7/27 19:37
 * description:Nacos配置
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(NacosBeanDefinitionRegistrar.class)
public @interface EnableNacosConfig {

    NacosProperties globalProperties();

}
