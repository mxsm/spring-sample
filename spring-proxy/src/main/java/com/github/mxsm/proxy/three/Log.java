package com.github.mxsm.proxy.three;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mxsm
 * @date 2021/11/26 11:36
 * @Since 1.0.0
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Log {

    /**
     * log template
     * @return
     */
    String template() default "";

    /**
     * request ip
     * @return
     */
    String ip() default "";

    /**
     * operator id
     * @return
     */
    String userId() default "";

    /**
     * user name
     * @return
     */
    String userName() default "";


    /**
     * operate type
     * @return
     */
    OperateType operate() default OperateType.SEARCH;

    /**
     * current timestamp
     * @return
     */
    long currentTime() default 0L;
}
