package com.xhx.exercise;

import org.junit.Test;

/**
 * 304给定一个二维矩阵 matrix，以下类型的多个请求：
 */
public class Test23 {
    @Test
    public void test(){
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix(matrix);

        System.out.println(sumRegion(2, 1, 4, 3)); // return 8 (红色矩形框的元素总和)
        System.out.println(sumRegion(1, 1, 2, 2)); // return 11 (绿色矩形框的元素总和)
        System.out.println(sumRegion(1, 2, 2, 4)); // return 12 (蓝色矩形框的元素总和)
    }

    int sums[][];
    public void NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0){
            int n = matrix[0].length;
            sums = new int[m][n+1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j+1] = sums[i][j]+matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += sums[i][col2+1] - sums[i][col1];
        }
        return res;
    }
}
