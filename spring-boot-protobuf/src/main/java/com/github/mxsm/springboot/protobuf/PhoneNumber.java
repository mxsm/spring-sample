package com.github.mxsm.springboot.protobuf;


/**
 * @author mxsm
 * @date 2022/1/28 18:00
 * @Since 1.0.0
 */
public class PhoneNumber {
    private String number;
    private PhoneType type;

    public PhoneNumber(String number, PhoneType type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }
}
