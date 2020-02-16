package com.github.mxsm.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author mxsm
 * @Date 2019/12/25 15:54
 */
public class SolutionLuoMa {

    public int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }

    public String intToRoman(int num) {

        if (num < 1 || num > 3999) {
            return "";
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD" );
        map.put(500, "D");
        map.put(900, "CM" );
        map.put(1000, "M");

        int nu = 0;
        int re = 0;
        LinkedList<String> buffer = new LinkedList<>();
        while (true) {
            re = num % 10;
            num = num / 10;
            if (re == 0) {
                ++nu;
            }else{
                buffer.addFirst(map.get((int)(re * Math.pow(10,nu))));
                nu = 0;
            }
            if(num <= 0){
                break;
            }
        }

        return buffer.stream().collect(Collectors.joining());
    }
}
