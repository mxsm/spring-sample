package com.github.mxsm.algorithm;

/**
 * @author mxsm
 * @Date 2020/6/7
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {

        int leng = s.length();
        int h = numRows;
        int size = numRows + numRows-2;
        int w = (leng / size) * (numRows-1);

        int i = leng % size;
        if(i != 0){
            if(i <= numRows){
                w +=1;
            }else{
                w = w + 1 + (i - numRows);
            }

        }


        return null;
    }

}
