package com.xhx.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 *
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 10^9 + 7 取余 后的结果。
 *
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 *
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */
public class Test8 {
    @Test
    public void test(){
        System.out.println(findPaths(2,2,2,0,0));
    }

    int MOD = 1000000007;
    int[][][] dp;// dp[i][j][move] 代表从 idx 为 i、j 的位置出发，移动步数不超过 move 的路径数量
    int[][] lj = {{0,1}, {0,-1}, {-1,0}, {1,0}};
    /*public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m+1][n+1][maxMove+1];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(m, n, startRow,startColumn, maxMove);
    }

    private int dfs(int m, int n, int row, int col, int move) {
        if(row < 0 || col < 0 || row >= m || col >= n) return 1;
        if(move == 0) return 0;
        if(dp[row][col][move] != -1) return dp[row][col][move];
        if((m - row > move) && (n - col > move) && (row >= move) && (col >= move)) return 0;
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            sum += dfs(m, n, row + lj[i][0], col + lj[i][1], move - 1);
            sum %= MOD;
        }
        dp[row][col][move] = sum;
        return sum;
    }*/

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m+1][n+1][maxMove+1];
        for (int move = 0; move < maxMove; move++) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if (i == 0 || i == m-1 || j == 0 || j == n-1){
                        dp[i][j][move] = 1;//边界设为1
                    }
                }
            }
        }
        for (int move = 1; move < maxMove; move++) {
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    for (int[] ints : lj) {
                        int i1 = i + ints[0];
                        int j1 = j + ints[1];
                        if (i1 >= 0 && j1 >= 0 && i1 < m && j1 < n) {
                            dp[i][j][move] += dp[i + ints[0]][j + ints[1]][move - 1];
                            dp[i][j][move] %= MOD;
                        }
                    }
                }
            }
        }
        return dp[m][n][maxMove];
    }

}
