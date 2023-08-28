package com.xhx.exercise;

import org.junit.Test;

/**
 * 1267 统计参与通信的服务器
 *
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 *
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 *
 * 0,0,1,0,1
 * 0,1,0,1,0
 * 0,1,1,1,0
 * 1,0,0,1,1
 * 0,0,1,1,0
 */
public class Test57 {
    @Test
    public void test(){
        int[][] grid = {{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}};
        //int[][] grid = {{1,0},{1,1}};
        //int[][] grid = {{0,0,1,0,1},{0,1,0,1,0},{0,1,1,1,0},{1,0,0,1,1},{0,0,1,1,0}};
        System.out.println(countServers(grid));
    }

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] bol = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    continue;
                }
                //行
                boolean link = false;
                for (int k = 0; k < n & k != j; k++) {
                    if (grid[i][k] == 1){
                        if (!bol[i][k]){
                            bol[i][k] = true;
                            res++;
                        }
                        link = true;
                    }
                }
                //下
                for (int k = 0; k < m & k != i; k++) {
                    if (grid[k][j] == 1){
                        if (!bol[k][j]){
                            bol[k][j] = true;
                            res++;
                        }
                        link = true;
                    }
                }
                if (link && !bol[i][j]){
                    bol[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
