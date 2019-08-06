package com.github.mxsm.algorithm;

/**
 * @author mxsm
 * @Date 2019/8/3 23:18
 * description:
 */
public class Palindrome {

    public boolean isPalindrome(int x) {

        if(x < 0){
            return false;
        }
        if(x <= 9){
            return true;
        }
        int copy = x;
        int rev = 0;
        while (copy != 0) {
            int pop = copy % 10;
            copy /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return false;
            rev = rev * 10 + pop;
        }
        return rev == x?true:false;
    }

}
