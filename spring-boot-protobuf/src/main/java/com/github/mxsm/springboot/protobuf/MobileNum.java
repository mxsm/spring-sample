package com.github.mxsm.springboot.protobuf;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mxsm
 * @date 2022/1/30 16:20
 * @Since 1.0.0
 */
@Documented
@Constraint(validatedBy = MobileNumValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MobileNum {

    String message() default "{com.github.mxsm.MobileNum.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
