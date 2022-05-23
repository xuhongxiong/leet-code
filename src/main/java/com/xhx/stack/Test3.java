package com.xhx.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * <p>Project: Test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test3 {

    @Test
    public void test1() {
        String a = "3[a2[c]]";
        System.out.println(decodeString(a));
    }

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a 或 2[4]的输入
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     */
    public String decodeString(String s) {
        Stack<Integer> integers = new Stack<Integer>();
        Stack<StringBuilder> sbStack = new Stack<StringBuilder>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                num = (num*10) + Integer.parseInt(String.valueOf(c));
            } else if (c == '['){
                integers.push(num);
                sbStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']'){
                Integer integer = integers.pop();
                StringBuilder pop = sbStack.pop();
                for (int i = 0; i < integer; i++) {
                    pop.append(sb);
                }
                sb = pop;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
