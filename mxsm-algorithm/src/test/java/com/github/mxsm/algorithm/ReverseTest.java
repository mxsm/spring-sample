package com.github.mxsm.algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ReverseTest {

    @Test
    public void reverse() {

       int result =  new Reverse().reverse(-2147483648);
       assertEquals(0,result);
    }

    @Test
    public void plusOne() {

        int[] result =  new PlusOne().plusOne(new int[]{2,4,9,3,9});
        String arryas = Arrays.asList(result).stream().map(item->item.toString()).collect(Collectors.joining(",","[","]"));
        System.out.println(arryas);
    }
}