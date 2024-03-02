package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * 48 旋转图像
 */
public class Test69 {
    @Test
    public void test(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        boolean[][] bol = new boolean[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (bol[i][j]){
                    continue;
                }
                int a = i;
                int b = j;
                int temp = matrix[i][j];
                int temp1;
                for (int k = 0; k < 4; k++) {
                    bol[a][b] = true;
                    if (k==3) {
                        matrix[a][b] = temp;
                        break;
                    }
                    matrix[a][b] = matrix[n-b-1][a];
                    temp1 = b;
                    b = a;
                    a = n-temp1-1;
                }
            }
        }
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
