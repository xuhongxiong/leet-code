package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 56 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Test71 {

    @Test
    public void test(){
        //int[][] intervals = {{1,4},{4,5}};
//        int[][] intervals = {{1,3},{2,6},{15,18},{8,10}};
        int[][] intervals = {{1,4},{2,3}};
        int[][] merge = merge(intervals);
        System.out.println(1);
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> collect = Arrays.stream(intervals).sorted((o1, o2) -> {
            if (o1[0]>o2[0]){
                return 1;
            } else if (o1[0]<o2[0]){
                return -1;
            } else if (o1[1]>o2[1]){
                return 1;
            } else if (o1[1]<o2[1]){
                return -1;
            }
            return 0;
        }).collect(Collectors.toList());
        List<int[]> resultList = new ArrayList<>();
        int[] step = new int[2];
        for (int i = 0; i < collect.size(); i++) {
            int[] ints = collect.get(i);
            if (i == 0){
                step = ints;
                continue;
            }
            if (ints[0] > step[1]){
                resultList.add(step);
                step = ints;
            } else if (step[1] < ints[1]){
                step[1] = ints[1];
            }
        }
        resultList.add(step);
        int[][] res = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }
}
