package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 * 提示：
 *
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 */
public class Test35 {
    @Test
    public void test(){
        //1,1000000000
        int[] nums = {1,2,3};
        System.out.println(minMoves(nums));
    }

    public int minMoves(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            minValue = Math.min(num,minValue);
        }
        int res = 0;
        for (int num : nums) {
            res += num-minValue;
        }
        return res;
    }


}
