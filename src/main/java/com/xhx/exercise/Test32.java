package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * 面试题16.21 交换和
 *
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 示例:
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3] 11,15
 * 示例:
 *
 * 输入: array1 =
 * [1, 2, 3], array2 = [4, 5, 6]
 *
 * 输出: []
 * 提示：
 *
 * 1 <= array1.length, array2.length <= 100000
 */
public class Test32 {
    @Test
    public void test(){
        //int[] array1 = {519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};//[4718,78]
        //int[] array2 = {52, 20, 78, 50, 38, 96, 81, 20};
//        int[] array1 = {4, 1, 2, 1, 1, 2};
//        int[] array2 = {3, 6, 3, 3};
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        System.out.println(Arrays.toString(findSwapValues(array1,array2)));
    }

    // sum1 -x + y = sum2 + x - y
    // => (sum1 - sum2)/2 = x - y
    public int[] findSwapValues(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int sum1 = Arrays.stream(array1).sum();
        int sum2 = Arrays.stream(array2).sum();
        int sub = sum2 - sum1;
        if (sub%2 > 0){
            return new int[0];
        }
        int diff = sub/2;
        for (int a1 : array1) {

            int target = diff+a1;
            int left = 0, right = array2.length-1;
            while (left <= right){
                int mid = (right+left)>>>1;
                if (array2[mid] == target){
                    return new int[]{a1, array2[mid]};
                } else if (array2[mid] < target){
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return new int[0];
    }
}
