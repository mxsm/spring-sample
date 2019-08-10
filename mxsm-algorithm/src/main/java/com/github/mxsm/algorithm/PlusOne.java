package com.github.mxsm.algorithm;

/**
 * @author mxsm
 * @Date 2019/8/8 0:30
 * description:
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

       int length = digits.length;
       boolean need = false;
       do {
           digits[length-1]  = digits[length-1]+1;

           if(digits[length-1] != 10){
              return digits;
           }
           if(length-1<=0){
               digits[length-1] = 0;
               need = true;
               break;
           }
           digits[length-1] = 0;
           length--;

       }while (length > 0);
       if(need){
           int[] target = new int[digits.length+1];
           target[0] = 1;
           for(int i = 1; i <= digits.length; ++i){
               target[i]=digits[i-1];
           }
           return target;
       }
        return digits;
    }

}
