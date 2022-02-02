package com.github.mxsm.springboot.protobuf;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.awt.print.Book;
import java.util.Set;

/**
 * @author mxsm
 * @date 2022/1/30 20:14
 * @Since 1.0.0
 */
public class ValidationMain {

    public static void main(String[] args) {
        Person person = new Person();
        person.setMobile("122222222");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate( person );
        ConstraintViolation<Person> next = constraintViolations.iterator().next();
        String message = next.getMessage();
        System.out.println(message);
    }


    public static class Person{
        @MobileNum
        //@Email
        private String mobile;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }
    }
}
