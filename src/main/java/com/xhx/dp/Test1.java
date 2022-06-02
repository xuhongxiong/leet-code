package com.xhx.dp;

import org.junit.Test;

/**
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 */
public class Test1 {
    @Test
    public void test(){
        System.out.println(uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {
        /*if (m == 1){
            return 1;
        }
        if (n == 1){
            return 1;
        }
        return uniquePaths(m-1,n) + uniquePaths(m,n-1);*/
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0){
                    ints[i][j] = 1;
                }else {
                    ints[i][j] = ints[i-1][j] + ints[i][j-1];
                }
            }
        }
        return ints[m-1][n-1];
    }
}
