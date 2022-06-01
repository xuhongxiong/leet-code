package com.xhx.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 * 输入：board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * 输出：true
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字（1-9）或者 '.'
 */
public class Test12 {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        set.add('1');
        set.add('.');
        System.out.println();
    }
    @Test
    public void test(){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
  ,{'6','.','.','1','9','5','.','.','.'}
  ,{'.','9','8','.','.','.','.','6','.'}
  ,{'8','.','.','.','6','.','.','.','3'}
  ,{'4','.','.','8','.','3','.','.','1'}
  ,{'7','.','.','.','2','.','.','.','6'}
  ,{'.','6','.','.','.','.','2','8','.'}
  ,{'.','.','.','4','1','9','.','.','5'}
  ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<String> stringList = Arrays.asList(i + "row", j + "line", getSudoku(i, j));
                String rowKey = i + "row";
                String lineKey = j + "line";
                String sudoku = getSudoku(i, j);
                for (String s : stringList) {
                    if ('.'==board[i][j]){
                        continue;
                    }
                    if (map.containsKey(s)){
                        Set<Character> characters = map.get(s);
                        if (characters.contains(board[i][j])){
                            return false;
                        } else {
                            characters.add(board[i][j]);
                        }
                    } else {
                        map.put(s,new HashSet<>(Collections.singletonList(board[i][j])));
                    }
                }
            }
        }
        return true;
    }
    private String getSudoku(int i, int j){
        return i/3 + "" + j/3;
    }
}
