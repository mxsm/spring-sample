package com.github.mxsm.bean;

import org.springframework.stereotype.Service;

@Service
public class B {

    private A a;

    public B(A a) {
        this.a = a;
    }
}
