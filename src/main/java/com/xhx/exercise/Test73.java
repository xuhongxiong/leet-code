package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * 59 螺旋矩阵2
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 */
public class Test73 {

    @Test
    public void test(){
        int[][] ints = generateMatrix(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] generateMatrix(int n) {
        int length = n * n;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] res = new int[n][n];
        int x = 0;
        int y = 0;
        int d = 0;
        for (int i = 1; i <= length; i++) {
            res[x][y] = i;
            int a = x + dir[d][0];
            int b = y + dir[d][1];
            //转向
            switch (d){
                case 0:
                    if (b == n || res[a][b] > 0){
                        d = 1;
                    }
                    break;
                case 1:
                    if (a == n || res[a][b] > 0){
                        d = 2;
                    }
                    break;
                case 2:
                    if (b < 0 || res[a][b] > 0){
                        d = 3;
                    }
                    break;
                case 3:
                    if (res[a][b] > 0){
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
