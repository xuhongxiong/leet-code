package com.xhx.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 */
public class Test4 {
    @Test
    public void test(){
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(2));
        res.add(Arrays.asList(3,4));
        res.add(Arrays.asList(6,5,7));
        res.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(res));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int resInt = Integer.MAX_VALUE;
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> item = triangle.get(i);
            for (int j = item.size()-1; j >= 0; j--) {
                if (i == 0){
                    dp[j] = item.get(j);
                } else {
                    if (j == 0){
                        dp[j] = item.get(j) + dp[j];
                    } else if (j == item.size()-1){
                        dp[j] = item.get(j) + dp[j-1];
                    } else {
                        dp[j] = item.get(j) + Math.min(dp[j],dp[j-1]);
                    }
                }
                if (i == triangle.size()-1){
                    resInt = Math.min(resInt,dp[j]);
                }
            }
        }
        return resInt;
    }
}
