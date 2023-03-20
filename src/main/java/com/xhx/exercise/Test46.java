package com.xhx.exercise;

import org.junit.Test;

/**
 *  leetcode48 旋转图像
 *  给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * [1,2,3]    [7,4,1]
 * [4,5,6]    [8,5,2]
 * [7,8,9]    [9,6,3]
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class Test46 {
    @Test
    public void test(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //延[0][0] [n][n]对换位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //延中间[0][n/2] [n][n/2]垂直对换位置
        for (int i = 0; i < n; i++) {
            for (int j = 0,k = n-1; j < n/2; j++,k--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
            }
        }
        System.out.println(1);
    }
}
