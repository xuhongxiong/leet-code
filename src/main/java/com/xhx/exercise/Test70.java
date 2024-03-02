package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 53 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * Related Topics
 * 数组
 * 分治
 * 动态规划
 */
public class Test70 {
    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /*public int maxSubArray(int[] nums) {
        int count = 0;
        int leftCount = Integer.MIN_VALUE;
        boolean ne = true;
        for (int num : nums) {
            if (num < 0 && ne){
                leftCount = Math.max(num,leftCount);
                continue;
            }
            ne = false;
            if (num >= 0){
                count += num;
            } else if (count >= Math.abs(num)){
                leftCount = Math.max(leftCount,count);
                count += num;
            } else {
                leftCount = Math.max(leftCount,count);
                count = 0;
            }
        }
        if (ne){
            return leftCount;
        }
        return Math.max(leftCount,count);
    }*/
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
