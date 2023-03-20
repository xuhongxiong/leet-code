package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1590. 使数组和能被 P 整除
 * 给你一个正整数数组nums，请你移除 最短子数组（可以为 空），使得剩余元素的 和能被 p整除。 不允许将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1。
 *
 * 子数组定义为原数组中连续的一组元素。
 *
 * 示例 1：
 *
 * 输入：nums = [3,1,4,2], p = 6
 * 输出：1
 * 解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
 * 示例 2：
 *
 * 输入：nums = [6,3,5,2], p = 9
 * 输出：2
 * 解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
 * 示例3：
 *
 * 输入：nums = [1,2,3], p = 3
 * 输出：0
 * 解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
 * 示例 4：
 *
 * 输入：nums = [1,2,3], p = 7
 * 输出：-1
 * 解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
 * 示例 5：
 *
 * 输入：nums = [1000000000,1000000000,1000000000], p = 3
 * 输出：0
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= p <= 109
 */
public class Test43 {
    @Test
    public void test(){
        int[] nums = {3,1,4,2};
        System.out.println(minSubarray(nums,6));
    }

    public int minSubarray(int[] nums, int p) {
        /*int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%p == 0){
            return 0;
        }
        if (p > sum){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int stepNum = 0;
            for (int j = i; j < n; j++) {
                stepNum += nums[j];
                if ((sum-stepNum) != 0 && (sum-stepNum)%p == 0){
                    res = Math.min(res,j-i+1);
                }
            }
        }
        if (Integer.MAX_VALUE == res){
            return -1;
        }
        return res;*/
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num)%p;
        }
        if (sum == 0){
            return 0;
        }
        int n = nums.length;
        int res = n;
        int stepNum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stepNum,i);
            stepNum = (stepNum + nums[i])%p;
            if (map.containsKey((stepNum-sum+p)%p)){
                res = Math.min(res,i-map.get((stepNum-sum+p)%p)+1);
            }
        }
        if (n == res){
            return -1;
        }
        return res;
    }
}
