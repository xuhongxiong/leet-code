package com.xhx.exercise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;

/**
 * 2034 股票价格波动
 */
public class Test65 {

    public static void main(String[] args) {
        /*TreeSet<int[]> integers = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    o2[1] = o1[1];
                    return 0;
                } else if (o1[1] > o2[1]){
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        integers.add(new int[]{1,2});
        integers.add(new int[]{1,3});
        System.out.println(integers.toString());*/
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1,10);
        System.out.println("null");
        stockPrice.update(2,5);
        System.out.println("null");
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1,3);
        System.out.println("null");
        System.out.println(stockPrice.maximum());
        stockPrice.update(4,2);
        System.out.println("null");
        System.out.println(stockPrice.minimum());

        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> priceMap = new TreeMap<>();
    }
}

class StockPrice {
    int maxTimestamp = Integer.MIN_VALUE;
    TreeMap<Integer, Integer> priceMap = new TreeMap<>();
    HashMap<Integer, Integer> timestampMap = new HashMap<>();

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp,timestamp);
        int prePrice = timestampMap.getOrDefault(timestamp, 0);
        timestampMap.put(timestamp,price);
        if (prePrice > 0){
            //已存在
            priceMap.put(prePrice, priceMap.getOrDefault(prePrice, 0) - 1);
            if (priceMap.get(prePrice) == 0){
                priceMap.remove(prePrice);
            }
        }
        priceMap.put(price,priceMap.getOrDefault(price,0)+1);
    }

    public int current() {
        return timestampMap.get(maxTimestamp);
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }
}
