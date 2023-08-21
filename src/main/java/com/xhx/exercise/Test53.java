package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1177 构建回文串检测
 */
public class Test53 {
    @Test
    public void test() {
        String s = "abcda";
        int[][] queries = new int[][]{{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        //true,false,false,true,true
        System.out.println(canMakePaliQueries(s, queries).toString());
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            String sb = s.substring(query[0], query[1] + 1);
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < sb.length(); i++) {
                if (strings.contains(String.valueOf(sb.charAt(i)))) {
                    strings.remove(String.valueOf(sb.charAt(i)));
                } else {
                    strings.add(String.valueOf(sb.charAt(i)));
                }
            }
            int quotient = strings.size() / 2;
            res.add(quotient <= query[2]);
        }
        Object o = new Object();
        return res;
    }
}
