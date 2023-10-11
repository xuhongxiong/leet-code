package com.xhx.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 901 股票价格跨度
 */
public class Test64 {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 返回 1
        System.out.println(stockSpanner.next(80)); // 返回 1
        System.out.println(stockSpanner.next(60)); // 返回 1
        System.out.println(stockSpanner.next(70)); // 返回 2
        System.out.println(stockSpanner.next(60)); // 返回 1
        System.out.println(stockSpanner.next(75)); // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
        System.out.println(stockSpanner.next(85)); // 返回 6
    }
}

class StockSpanner {

    /*List<Stock> stockList;

    public StockSpanner() {
        stockList = new ArrayList<>();
    }

    public int next(int price) {
        int res = 1;
        for (int i = stockList.size()-1; i >= 0;) {
            Stock stock = stockList.get(i);
            if (price>=stock.price){
                res += stock.next;
                i -= stock.next;
            } else {
                break;
            }
        }
        stockList.add(new Stock(price,res));
        return res;
    }*/
    Deque<int[]> stack;
    int idx;
    public StockSpanner() {
        stack = new ArrayDeque<int[]>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }
}

class Stock {
    int price;
    int next;

    public Stock(int price, int next) {
        this.price = price;
        this.next = next;
    }
}
