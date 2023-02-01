package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2304 网格中的最小路径代价
 *
 * 输入：grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]
 * 输出：6
 * 解释： 最小代价的路径是 2 -> 3 。 - 路径途经单元格值之和 2 + 3 = 5 。 - 从 2 移动到 3 的代价为 1 。 路径总代价为 5 + 1 = 6 。
 */
public class Test25 {
    @Test
    public void test(){
        int[][] grid = {{5,1,2},{4,0,3}};
        int[][] moveCost = {{12,10,15},{20,23,8},{21,7,1},{8,1,13},{9,10,25},{5,3,2}};
        System.out.println(minPathCost(grid,moveCost));
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] resArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (i == 0){
                System.arraycopy(grid[i], 0, resArr[i], 0, n);
            } else {
                for (int j = 0; j < n; j++) {
                    int[] ints = new int[n];
                    for (int k = 0; k < n; k++) {
                        int value = grid[i-1][k];
                        ints[k] = resArr[i-1][k] + moveCost[value][j];
                    }
                    Arrays.sort(ints);
                    resArr[i][j] = grid[i][j] + ints[0];
                }
            }
        }
        int[] ints = resArr[m - 1];
        Arrays.sort(ints);
        return ints[0];
    }
}
