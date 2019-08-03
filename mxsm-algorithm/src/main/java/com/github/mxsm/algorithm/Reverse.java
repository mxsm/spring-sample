package com.github.mxsm.algorithm;

/**
 * @author mxsm
 * @Date 2019/8/3 22:46
 * description:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {

    public int reverse(int x) {
        long current = (long)x;
        if(x == 0){
            return 0;
        }
        boolean negative = false;
        //首先判断正负
        if(x < 0){
            current = (-current);
            negative = true;
        }
        //%10读取最小值
        StringBuffer stringBuffer = new StringBuffer();
        do{
            stringBuffer.append(current%10);
            current = current / 10;
        }while (current > 0);
        //根据Long判断数值
        long value = Long.parseLong(stringBuffer.toString());
        if(negative){
            if(-value < Integer.MIN_VALUE){
                return 0;
            }else{
                return (int)-value;
            }
        }

        if(value > Integer.MAX_VALUE){
            return 0;
        }else{
            return (int)value;
        }
    }
}
