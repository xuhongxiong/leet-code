package com.xhx.efcz;

import org.junit.Test;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * 1、同底数幂相乘，底数不变，指数相加。
 * 2、幂的乘方，底数不变，指数相乘。
 */
public class Test11 {
    @Test
    public void test(){
        double x = 2.10000;
        int n = 3;
        System.out.println(myPow(x,n));
    }

    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n;i != 0;i /= 2){
            if (i%2 != 0){
                res *= x;
            }
            x *= x;
        }
        return n>=0 ? res : 1/res;
    }
}
