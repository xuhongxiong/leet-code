package com.xhx.exercise;

import org.junit.Test;

/**
 * 5 最长回文字符串
 */
public class Test66 {
    @Test
    public void test(){
        System.out.println(longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1){
            return s;
        }
        int max = 0;
        String res  = null;
        for (int i = 0; i < length-1; i++) {
            char c = s.charAt(i);
            String dp = dp(s.substring(i, length), c);
            if (dp.length() > max){
                max = dp.length();
                res = dp;
            }
        }
        return res;
    }

    private String dp(String str,char c){
        int index = str.lastIndexOf(c);
        if (index < 1){
            return String.valueOf(c);
        }
        String substring = str.substring(0, index + 1);
        if (substring.equals(new StringBuilder(substring).reverse().toString())){
            return substring;
        } else {
            return dp(str.substring(0,index),c);
        }
    }
}
