package com.xhx.efcz;

import org.junit.Test;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 *
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 *
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 *
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 *
 * 2 <= letters.length <= 104
 * letters[i]是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同的字母
 * target 是一个小写字母
 */
public class Test13 {
    @Test
    public void test(){
        char[] letters = {'c', 'f', 'j'};
        char target = 'j';
        System.out.println(nextGreatestLetter(letters,target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        while (left < right) {
            int mid = left + ((right-left)>>>1);
            if (letters[mid] <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (letters[left] > target){
            return letters[left];
        }
        return letters[0];
    }
}
