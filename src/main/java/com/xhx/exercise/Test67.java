package com.xhx.exercise;

import org.junit.Test;

/**
 * 29 两数相除
 * 被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2^31,  2^31 − 1] 。本题中，如果商 严格大于 2^31 − 1 ，则返回 2^31 − 1 ；如果商 严格小于 -2^31 ，则返回 -2^31 。
 *
 * 输入: dividend = 10, divisor = 3 输出: 3 解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
 *
 * -2^31 <= dividend, divisor <= 2^31 - 1
 * divisor != 0
 */
public class Test67 {
    @Test
    public void test(){
        //2147483647
        System.out.println(divide(10,3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE){
            if (divisor == 1){
                return Integer.MIN_VALUE;
            }
            if (divisor == -1){
                return Integer.MAX_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE){
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == 0){
            return 0;
        }
        boolean bol = true;
        if (dividend > 0){
            dividend = -dividend;
            bol = false;
        }
        if (divisor > 0){
            divisor = -divisor;
            bol = !bol;
        }
        int left = 1;
        int right = Integer.MAX_VALUE;
        int res = 0;
        while (left <= right){
            int mid = left+((right-left)>>1);
            boolean check = quickAdd(dividend, divisor, mid);
            if (check){
                res = mid;
                if (mid == Integer.MAX_VALUE){
                    break;
                }
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        return bol ? res : -res;
    }

    //x->dividend  y->divisor z->value 都是负数 快速乘
    private boolean quickAdd(int x, int y, int z){
        int result = 0;
        int add = y;
        while (z != 0){
            if ((z&1) != 0){
                if (result < x-add){
                    return false;
                }
                result+=add;
            }
            if (z!=1){
                if (add < x-add){
                    return false;
                }
                add += add;
            }
            z>>=1;
        }
        return true;
    }

}
