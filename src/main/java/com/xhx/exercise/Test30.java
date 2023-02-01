package com.xhx.exercise;

import org.junit.Test;

/**
 * 688 骑士在棋盘上的概率
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 *
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 *
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 *
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 *
 * 示例 1：
 *
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 * 示例 2：
 *
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 * 提示:
 *
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n - 1
 *
 * 题解：
 * 定义f[i][j][p]为从位置(i,j)出发，使用步数不超过p步，最后仍在棋盘的概率
 */
public class Test30 {
    @Test
    public void test(){
        System.out.println(knightProbability(10,13,5,3));
    }

    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0){
            return 1;
        }
        //8个方向
        int[][] dirs = new int[][]{{2,1},{2,-1},{-2,-1},{-2,1},{1,2},{-1,2},{1,-2},{-1,-2}};
        double[][][] f = new double[n][n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][0] = 1;
            }
        }
        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int nx = i + dir[0], ny = j + dir[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        f[i][j][p] += f[nx][ny][p - 1] / 8;
                    }
                }
            }
        }
        return f[row][column][k];
    }

}
