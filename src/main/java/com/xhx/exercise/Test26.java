package com.xhx.exercise;


import org.junit.Test;

import java.util.regex.Pattern;

/**
 * 917 仅仅反转字母
 */
public class Test26 {
    @Test
    public void test(){
        System.out.println(reverseOnlyLetters("ab-cd"));
    }

    public String reverseOnlyLetters(String s) {
        int n = s.length();
        StringBuilder reverse = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            if (Character.isLetter(s.charAt(i))){
                reverse.append(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(s.charAt(i))){
                res.append(reverse.charAt(j));
                j++;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
