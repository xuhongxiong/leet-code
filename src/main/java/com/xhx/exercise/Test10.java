package com.xhx.exercise;

import org.junit.Test;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED" 输出：true
 *
 * 解答失败: 测试用例:[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]] "ABCESEEEFS" 测试结果:false 期望结果:true stdout:
 *
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class Test10 {
    @Test
    public void test(){
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"ABCESEEEFS"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] bol = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]){
                    boolean res = dfs(i,j,bol,board,word,0);
                    if (res){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, boolean[][] bol, char[][] board, String word, int k) {
        if (board[i][j] != word.charAt(k)){
            return false;
        }
        if (k == word.length()-1){
            return true;
        }
        bol[i][j] = true;
        int m = bol.length;
        int n = bol[0].length;
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean res = false;
        for (int[] ints : direction) {
            int newI = i + ints[0];
            int newJ = j + ints[1];
            if (newI<m && newI>=0 && newJ<n && newJ>=0 && !bol[newI][newJ]){
                boolean dfs = dfs(newI, newJ, bol, board, word, k+1);
                if (dfs){
                    res =  true;
                    break;
                }
            }
        }
        //还原
        bol[i][j] = false;
        return res;
    }
}
