package com.xhx.exercise;

import org.junit.Test;

/**
 * 2594 修车的最少时间
 */
public class Test63 {
    @Test
    public void test(){

    }

    public long repairCars(int[] ranks, int cars) {
        long l = 1L;
        long r = (long) ranks[0] *cars*cars;
        while (l < r){
            long m = l + r >> 1;
            if (check(ranks,cars,m)){
                r = m;
            } else {
                l = m+1;
            }
        }
        return l;
    }

    private boolean check(int[] ranks,int cars,long m){
        long cnt = 0;
        for (int rank : ranks) {
            cnt += Math.sqrt(m/rank);
        }
        return cnt >= cars;
    }
}
