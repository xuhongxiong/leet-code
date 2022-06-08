package com.xhx.dp;

import org.junit.Test;

/**
 * 给你一个n x n 整数矩阵arr，请你返回 非零偏移下降路径 数字和的最小值。
 *
 * 非零偏移下降路径 定义为：从arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 *
 * 输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是[1,5,7] ，所以答案是13 。
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 */
public class Test6 {
    @Test
    public void test(){
//        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] grid = {{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{97,91,61,-46,67}};
        System.out.println(minFallingPathSum(grid));
    }
    //时间复杂度：O(n^3)
    //空间复杂度：O(n^2)
    /*public int minFallingPathSum(int[][] grid) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i > 0){
                    int rowMin = Integer.MAX_VALUE;
                    for (int m = 0; m < grid[i - 1].length; m++) {
                        if (j != m){
                            rowMin = Math.min(rowMin,grid[i - 1][m]);
                        }
                    }
                    grid[i][j] = grid[i][j] + rowMin;
                }
                if (i == grid.length-1){
                    res = Math.min(res,grid[i][j]);
                }
            }
        }
        return res;
    }*/
    //时间复杂度：O(n^2)
    //空间复杂度：O(n^2)

    //{{-73,61,43,-48,-36},
    // {3,30,27,57,10},
    // {96,-76,84,59,-15},
    // {5,-49,76,31,-7},
    // {97,91,61,-46,67}};
    public int minFallingPathSum(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int i1 = -1,i2 = -1;
        for (int i = 0; i < grid.length; i++) {
            int ti1 = -1,ti2 = -1;
            for (int j = 0; j < grid[i].length; j++) {
                if (i > 0){
                    int rowMin;
                    if (j != i1){
                        rowMin = grid[i-1][i1];
                    } else {
                        rowMin = grid[i-1][i2];
                    }
                    grid[i][j] = grid[i][j] + rowMin;
                }
                if (ti1 == -1 || grid[i][j] < grid[i][ti1]){
                    ti2 = ti1;
                    ti1 = j;
                } else if (ti2 == -1 || grid[i][j] < grid[i][ti2]){
                    ti2 = j;
                }
                if (i == grid.length-1){
                    res = Math.min(res,grid[i][j]);
                }
            }
            i1 = ti1;
            i2 = ti2;
        }
        return res;
    }
}
