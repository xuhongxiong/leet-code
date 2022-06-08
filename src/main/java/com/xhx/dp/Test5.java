package com.xhx.dp;

import org.junit.Test;

/**
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 */
public class Test5 {
    @Test
    public void Test(){
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i > 0){
                    if (j == 0){
                        matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                    } else if (j == matrix[i].length-1){
                        matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j-1],matrix[i-1][j]);
                    } else {
                        matrix[i][j] = matrix[i][j] + Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]),matrix[i-1][j+1]);
                    }
                }
                if (i == matrix.length-1){
                    res = Math.min(res,matrix[i][j]);
                }
            }
        }
        return res;
    }
}
