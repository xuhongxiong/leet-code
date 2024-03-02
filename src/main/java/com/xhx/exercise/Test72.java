package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 72 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]] 输出：[1,2,3,6,9,8,7,4,5]
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]] 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Test72 {

    @Test
    public void test(){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        List<Integer> res = new ArrayList<>();
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] step = new boolean[m][n];
        int d = 0;//方向
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            step[x][y] = true;

            int a = x + dir[d][0];
            int b = y + dir[d][1];

            //转向
            switch (d){
                case 0:
                    if (b == n || step[a][b]){
                        d = 1;
                    }
                    break;
                case 1:
                    if (a == m || step[a][b]){
                        d = 2;
                    }
                    break;
                case 2:
                    if (b < 0 || step[a][b]){
                        d = 3;
                    }
                    break;
                case 3:
                    if (step[a][b]){
                        d = 0;
                    }
                    break;
            }
            x = x + dir[d][0];
            y = y + dir[d][1];
        }
        return res;
    }
}
