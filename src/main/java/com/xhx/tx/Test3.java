package com.xhx.tx;

import org.junit.Test;

/**
 * 买卖股票的最佳时机
 */
public class Test3 {

    @Test
    public void test(){
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length-1; ) {
            int max = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                i++;
                if (prices[j] > max) {
                    res += prices[j] - max;
                    max = prices[j];
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
