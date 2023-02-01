package com.xhx.exercise;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1：
 *
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 *
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 *
 * 提示：
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 */
public class Test21 {

    @Test
    public void test(){
        int[] prices = new int[]{1,3,7,5,10,3};
        System.out.println(maxProfit(prices,3));
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 1){
            return 0;
        }
        int res = 0;
        int base = prices[0]+fee;//买入数据
        for (int i = 1; i < n; i++) {
            if (prices[i] > base){
                //比买入价格高
                res += (prices[i]-base);
                base = prices[i];//继续往前
            } else if (prices[i] + fee < base){
                //到达顶点
                base = prices[i]+fee;
            }
        }
        return res;
    }


}
