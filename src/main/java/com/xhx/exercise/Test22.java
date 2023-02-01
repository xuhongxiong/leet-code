package com.xhx.exercise;

import org.junit.Test;

/**
 * 给你一个仅由数字（0 - 9）组成的字符串 num 。
 *
 * 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
 *
 * 注意：
 *
 * 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
 * 数字可以重新排序。
 * 示例 1：
 *
 * 输入：num = "444947137"
 * 输出："7449447"
 * 解释：
 * 从 "444947137" 中选用数字 "4449477"，可以形成回文整数 "7449447" 。
 * 可以证明 "7449447" 是能够形成的最大回文整数。
 * 示例 2：
 *
 * 输入：num = "00009"
 * 输出："9"
 * 解释：
 * 可以证明 "9" 能够形成的最大回文整数。
 * 注意返回的整数不应含前导零。
 * 提示：
 *
 * 1 <= num.length <= 105
 * num 由数字（0 - 9）组成
 */
public class Test22 {
    @Test
    public void test(){
        System.out.println(largestPalindromic("00001105"));
    }

    public String largestPalindromic(String num) {
        int[] intArr = new int[10];
        int n = num.length();
        for (int i = 0; i < n; i++) {
            intArr[num.charAt(i) - '0'] += 1;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && ans.length() == 0){
                break;
            }
            int a = intArr[i]/2;
            intArr[i] -= a*2;
            for (int j = 0; j < a; j++) {
                ans.append(i);
            }
        }

        StringBuilder ansPlus = new StringBuilder(ans);
        ans.reverse();
        for (int i = 9; i >= 0; i--) {
            int a = intArr[i];
            if (a > 0){
                ansPlus.append(i);
                break;
            }
        }
        return ansPlus.append(ans).toString();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        String s = new String(sb);
        StringBuilder reverse = new StringBuilder(sb.reverse());
        System.out.println(s);
        System.out.println(sb);
        System.out.println(reverse);
        sb.append(1);
        System.out.println(s);
        System.out.println(sb);
        System.out.println(reverse);
    }

}
