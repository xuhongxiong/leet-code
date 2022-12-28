package com.xhx.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 37解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 *
 * 提示：
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 */
public class Test14 {

    boolean lineArr[][] = new boolean[9][9];
    boolean columnArr[][] = new boolean[9][9];
    boolean blockArr[][][] = new boolean[3][3][9];
    List<int[]> spaceList = new ArrayList<>();//存储.元素位置
    boolean last = false;//是否到最后一个
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.'){
                    spaceList.add(new int[]{i,j});
                } else {
                    int a = board[i][j]-'0'-1;//数组下标从0开始
                    lineArr[i][a] = columnArr[j][a] = blockArr[i/3][j/3][a] = true;
                }
            }
        }
        dfs(board,0);
    }
    //pos 位置
    public void dfs(char[][] board, int pos){
        if (pos == spaceList.size()){
            last = true;
            return;
        }
        int[] ints = spaceList.get(pos);
        int line = ints[0];
        int column = ints[1];
        for (int i = 0; i < 9 && !last; i++) {
            if (!lineArr[line][i] && !columnArr[column][i] && !blockArr[line/3][column/3][i]){
                lineArr[line][i] = columnArr[column][i] = blockArr[line/3][column/3][i] = true;
                board[line][column] = (char)(i+'0'+1);
                dfs(board,pos+1);
                //回溯
                lineArr[line][i] = columnArr[column][i] = blockArr[line/3][column/3][i] = false;
            }
        }
    }

    /**
     * 计算机的运算的时候，都是将原码转成补码进行运算的 结果为补码，再转成原码
     * 负数的反码是符号位不变，其余按位取反，负数的补码则是符号位不变，其余按位取反，最后再+ 1得到的， 例如：
     *
     * 15 , 原码:00001111  反码:00001111   补码:00001111
     * −15 ,原码:10001111  反码:11110000   补码:11110001
     *
     * 我们可以用b & (−b) 得到 b 二进制表示中最低位的 1，这是因为 (-b) 在计算机中以补码的形式存储
     */
    public static void main(String[] args) {
        //System.out.println(2 << 1);
        //5  0000 0101
        //-5 1101  1011
        //~5 1111 1010 -> 1111 1001 -> 1000 0110
        //~5+1 1000 0101
        //~5 & (~5+1)
        //~5 原码1000 0110 -> 反码1111 1001 -> 补码1111 1010
        //~5+1 原码1000 0101 -> 反码1111 1010 -> 补码1111 1011
        //~5 & (~5+1) 补码1111 1010 -> 反码1111 1001 -> 原码1000 0110

        System.out.println(5 & -5);
        System.out.println(~5);
        System.out.println(~5+1);
        System.out.println(~5 & (~5+1));
        /*for (int i = 0; i < 9; i++) {
            System.out.println(i);
        }*/
    }
}
