package com.github.mxsm.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseTest {

    @Test
    public void reverse() {

       int result =  new Reverse().reverse(-2147483648);
       assertEquals(0,result);
    }
}