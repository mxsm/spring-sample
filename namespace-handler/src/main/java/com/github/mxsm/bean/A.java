package com.github.mxsm.bean;

import org.springframework.stereotype.Service;

@Service
public class A {

    private B b;

    public A(B b) {
        this.b = b;
    }
}
