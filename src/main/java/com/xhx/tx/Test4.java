package com.xhx.tx;

import org.junit.Test;

/**
 * 加油站
 */
public class Test4 {
    @Test
    public void test(){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int gasSum = 0;
            int costSum = 0;
            int j = 0;
            while (j < n) {
                int index = (i + j) % n;
                gasSum += gas[index];
                costSum += cost[index];
                if (costSum > gasSum) {
                    break;
                }
                j++;
            }
            if (j == n) {
                return i;
            } else {
                i = i + j + 1;
            }
        }
        return -1;
    }
}
