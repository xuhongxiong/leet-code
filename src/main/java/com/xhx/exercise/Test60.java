package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 57 插入区间
 */
public class Test60 {
    @Test
    public void test(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        for (int i = 0; i < integers.size(); i++) {
            if (i == 1){
                integers.add(1,4);
            }
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean replace = false;
        for (int[] interval : intervals) {
            if (interval[0] > right){
                if (!replace){
                    list.add(new int[]{left,right});
                    replace = true;
                }
                list.add(interval);
            } else if (interval[1] < left){
                list.add(interval);
            } else {
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if (!replace){
            list.add(new int[]{left, right});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
