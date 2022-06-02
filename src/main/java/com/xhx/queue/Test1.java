package com.xhx.queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test1 {

    @Test
    public void test1() {
        int[] arr = {1,2,5,4,3,6,8};
        System.out.println(Arrays.toString(getTopMapNum(arr,2).toArray()));
    }


    public static List<Integer> getTopMapNum(int[] arr, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer> topKList = new ArrayList<>();
        if (arr == null || k > arr.length || k <= 0) {
            return topKList;
        }
        for (int i : arr) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(i);
            } else {
                if (priorityQueue.peek() < i) {
                    priorityQueue.poll();
                    priorityQueue.add(i);
                }
            }
        }

        while (k-- > 0) {
            topKList.add(priorityQueue.poll());
        }
        return topKList;
    }
}
