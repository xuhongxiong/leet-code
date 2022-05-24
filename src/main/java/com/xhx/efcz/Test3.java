package com.xhx.efcz;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test3 {

    /**
     * 猜数字游戏的规则如下：
     *
     * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
     * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
     *
     * -1：我选出的数字比你猜的数字小 pick < num
     * 1：我选出的数字比你猜的数字大 pick > num
     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     * 返回我选出的数字。
     *
     * 输入：n = 10, pick = 6
     * 输出：6
     *
     * 1 <= n <= 231 - 1
     * 1 <= pick <= n
     */
    @Test
    public void test(){
        System.out.println(guessNumber(10));
    }

    int picker = 6;
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left <= right){
            int mid = (left + right) >>> 1;
            int guess = guess(mid);
            if (guess == 0){
                return mid;
            } else if (guess < 0){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    int guess(int num) {
        return new BigDecimal(picker).compareTo(new BigDecimal(num));
    }
}
