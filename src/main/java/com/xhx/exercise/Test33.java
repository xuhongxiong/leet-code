package com.xhx.exercise;

import org.junit.Test;

/**
 * 1013 将数组分成和相等的三个部分
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
 *
 * 示例 1：
 * 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * 输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * 输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * 提示：
 * 3 <= arr.length <= 5 * 104
 * -104 <= arr[i] <= 104
 */
public class Test33 {
    @Test
    public void test(){
        //int[] arr = {3,3,6,5,-2,2,5,1,-9,4};
        int[] arr = {1,-1,-1,1};
        System.out.println(canThreePartsEqualSum(arr));
    }


    public boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for (int i : arr) {
            total += i;
        }
        if (total%3 != 0){
            return false;
        }
        int left = 0;
        int right = arr.length-1;
        int totalLeft = 0;
        int totalRight = 0;
        while (left <= right){
            if (left == 0 || totalLeft != total/3){
                totalLeft += arr[left];
                left++;
            } else if (right == arr.length-1 || totalRight != total/3){
                totalRight += arr[right];
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
