package com.xhx.exercise;

import org.junit.Test;

/**
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 *
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
 *
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 *
 * 示例 1：
 *
 * 输入：s = "XXX"
 * 输出：1
 * 解释：XXX -> OOO
 * 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
 */
public class Test3 {
    @Test
    public void test(){
        System.out.println(minimumMoves("XXOX"));
    }

    public int minimumMoves(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length;) {
            if ('O' == chars[i]){
                i++;
            } else {
                chars[i] = 'O';
                if (i + 1 < chars.length) chars[i + 1] = 'O';
                if (i + 2 < chars.length) chars[i + 2] = 'O';
                i += 3;
                res++;
            }
        }
        return res;
    }
}
