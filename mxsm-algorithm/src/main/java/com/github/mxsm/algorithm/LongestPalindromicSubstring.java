package com.github.mxsm.algorithm;

/**
 * 力扣地址：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * @author mxsm
 * @Date 2020/6/7
 */
public class LongestPalindromicSubstring {

    //中心扩散法
    public static String longestPalindrome(String s) {

        int len = s.length();
        if(len < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        int begin = 0;
        int tw = 0;

        for(int i = 0; i < len; ++i){

            int ctw = 0;
            int l = i;
            int r = i+1;
            if(i < 0){
                continue;
            }
            if(r > len-1){
                continue;
            }
            while (l >= 0 && r < len){
                if(chars[l] == chars[r]){
                    ctw += 2;
                    if(ctw > tw){
                        tw = ctw;
                        begin = l;
                    }
                    --l;
                    ++r;
                }else{
                    break;
                }
            }
        }

        int begin1 = 0;
        int tw1 = 0;
        for(int i = 0; i < len; ++i){

            int ctw = 1;
            int l = i-1;
            int r = i+1;
            if(i < 0){
                tw1 = 1;
                continue;
            }
            if(r > len-1){
                continue;
            }
            while (l >= 0 && r < len){
                if(chars[l] == chars[r]){
                    ctw += 2;
                    if(ctw > tw1){
                        tw1 = ctw;
                        begin1 = l;
                    }
                    --l;
                    ++r;
                }else{
                    break;
                }

            }
        }

        if(tw == 0 && tw1 == 0){
            return s.substring(0, 1);
        }

        return tw > tw1 ? s.substring(begin, begin+tw) : s.substring(begin1, begin1+tw1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcda"));
    }

}
