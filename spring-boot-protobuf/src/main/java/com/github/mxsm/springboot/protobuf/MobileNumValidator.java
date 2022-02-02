package com.github.mxsm.springboot.protobuf;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author mxsm
 * @date 2022/1/30 17:13
 * @Since 1.0.0
 */
public class MobileNumValidator implements ConstraintValidator<MobileNum,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(null == value || value.trim().length() != 11 || !value.matches("^[0-9]+$")){
            return false;
        }
        return true;
    }
}
