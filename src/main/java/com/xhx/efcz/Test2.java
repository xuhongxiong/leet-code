package com.xhx.efcz;

import org.junit.Test;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test2 {

    /**
     * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     * 输入：x = 4
     * 输出：2
     *
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */
    @Test
    public void test() {
        int i = mySqrt(8);
        System.out.println(i);
    }

    public int mySqrt(int x) {
        if (x < 2){
            return x;
        }
        int left = 0;
        int right = x;
        while (left <= right){
            int mid = (left + right) >>> 1;
            int midx = x / mid;
            if (midx == mid){
                return mid;
            } else if (midx < mid){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
