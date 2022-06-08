package com.xhx.dp;

import org.junit.Test;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class Test3 {
    @Test
    public void test(){
//        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    /*public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ints = new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0){
                    ints[i][j] = grid[i][j];
                } else if (i == 0){
                    ints[i][j] = grid[i][j] + ints[i][j-1];
                } else if (j == 0){
                    ints[i][j] = grid[i][j] + ints[i-1][j];
                } else {
                    ints[i][j] = grid[i][j] + Math.min(ints[i-1][j],ints[i][j-1]);
                }
            }
        }
        return ints[m-1][n-1];
    }*/
    int m, n;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][] f = new int[m][n];
        int[] g = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                } else {
                    int top  = i - 1 >= 0 ? f[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                    int left = j - 1 >= 0 ? f[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;
                    f[i][j] = Math.min(top, left);
                    g[getIdx(i, j)] = top < left ? getIdx(i - 1, j) : getIdx(i, j - 1);
                }
            }
        }

        // 从「结尾」开始，在 g[] 数组中找「上一步」
        int idx = getIdx(m - 1, n - 1);
        // 逆序将路径点添加到 path 数组中
        int[][] path = new int[m + n][2];
        path[m + n - 1] = new int[]{m - 1, n - 1};
        for (int i = 1; i < m + n; i++) {
            path[m + n - 1 - i] = parseIdx(g[idx]);
            idx = g[idx];
        }
        // 顺序输出位置
        for (int i = 1; i < m + n; i++) {
            int x = path[i][0], y = path[i][1];
            System.out.print("(" + x + "," + y + ") ");
        }
        System.out.println(" ");

        return f[m - 1][n - 1];
    }
    int[] parseIdx(int idx) {
        return new int[]{idx / n, idx % n};
    }
    int getIdx(int x, int y) {
        return x * n + y;
    }
}
