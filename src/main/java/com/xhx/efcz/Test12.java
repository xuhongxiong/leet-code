package com.xhx.efcz;

import org.junit.Test;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 进阶：不要 使用任何内置的库函数，如 sqrt
 *
 * 输入：num = 16
 * 输出：true
 *
 * 1 <= num <= 2^31 - 1
 */
public class Test12 {
    @Test
    public void test(){
        System.out.println(isPerfectSquare(1));
    }

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right){
            int mid = left + ((right-left)>>>1);
            if (mid == 0 || num%mid == 0 && mid==num/mid){
                return true;
            } else if (mid <= num/mid){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
