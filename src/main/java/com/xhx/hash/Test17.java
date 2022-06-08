package com.xhx.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Test17 {
    @Test
    public void test(){
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> next : map.entrySet()) {
            list.add(new int[]{next.getKey(), next.getValue()});
        }
        list.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;*/

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        /*PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue()-o2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size()>k){
                queue.poll();
            }
        }*/
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k){
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.peek())){
                priorityQueue.poll();
                priorityQueue.add(key);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()){
            res[i++] = priorityQueue.poll();
        }
        return res;
    }
}
