package com.xhx.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test5 {

    @Test
    public void test1() {
//        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] ints = updateMatrix(mat);
        System.out.println(Arrays.deepToString(ints));
    }

    /**
     * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
     * 两个相邻元素间的距离为 1 。
     *
     * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：[[0,0,0],[0,1,0],[0,0,0]]
     */

    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        LinkedList<Item> linkedList = new LinkedList<>();
        boolean[][] visitAble = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0){
                    linkedList.push(new Item(i,j));
                    visitAble[i][j] = true;
                }
            }
        }
        while (!linkedList.isEmpty()) {
            Item pop = linkedList.pop();
            int a = pop.getA();
            int b = pop.getB();
            for (int m = 0; m < dirs.length; m++) {
                int x = a + dirs[m][0];
                int y = b + dirs[m][1];
                if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && !visitAble[x][y]){
                    visitAble[x][y] = true;
                    mat[x][y] = mat[a][b] + 1;
                    linkedList.add(new Item(x,y));
                }
            }
        }
        return mat;
    }

    class Item {
        private int a;
        private int b;

        public Item(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
