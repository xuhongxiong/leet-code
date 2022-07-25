package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数整除的数。
 *
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 *
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 *
 * 示例 1：
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class Test4 {
    @Test
    public void test(){
        System.out.println((-5)/3);
        //System.out.println(selfDividingNumbers(1,22));
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        index: for (int i = left; i <= right; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            for (char aChar : chars) {
                int intChar = Integer.parseInt(String.valueOf(aChar));
                if (intChar == 0 || i%Integer.parseInt(String.valueOf(aChar)) != 0){
                    continue index;
                }
            }
            res.add(i);
        }
        return res;
    }
}
