package com.xhx.efcz;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 */
public class Test8 {
    @Test
    public void test(){
        /*int[] nums = {2,2};
        int target = 2;*/
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        /*int[] nums = {1,1,1};
        int target = 1;*/
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while (left+1<right){
            int mid = left + ((right-left) >>> 1);
            if (nums[mid] < target){
                left = mid;
            } else {
                right = mid;
            }
        }
        int newLeft;
        if (nums[left] == target){
            newLeft = left;
        } else if (nums[right] == target){
            newLeft = right;
        } else {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        result[0] = newLeft;
        int newRight = nums.length-1;
        while (newLeft+1<newRight){
            int mid = newLeft + ((newRight-newLeft) >>> 1);
            if (nums[mid] <= target){
                newLeft = mid;
            } else {
                newRight = mid;
            }
        }
        if (nums[newRight] == target){
            result[1] = newRight;
        } else {
            result[1] = newLeft;
        }
        return result;
    }
}
