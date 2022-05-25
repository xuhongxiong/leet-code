package com.xhx.efcz;

import org.junit.Test;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 */
public class Test10 {
    @Test
    public void test(){
//        int[] nums = {1,2,3,1};
        int[] nums = {3,2,1};
//        int[] nums = {1};
        System.out.println(findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        /*if (nums.length == 1){
            return 0;
        }*/
        int left = 0;
        int right = nums.length-1;
        while (left+1<right){
            int mid = left + ((right-left)>>>1);
            if (nums[mid] > nums[mid+1]){
                right = mid;
            } else {
                left = mid;
            }
        }
        if (left == right || nums[left] > nums[left + 1]){
            return left;
        } else {
            return right;
        }
    }
}
