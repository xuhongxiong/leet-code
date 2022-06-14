package com.xhx.tx;

import org.junit.Test;

/**
 * 跳跃游戏
 */
public class Test2 {
    @Test
    public void test(){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int step = 0;
        while (step < nums.length-1){
            int maxIndex = 0;
            if (step + nums[step] >= nums.length-1){
                return true;
            }
            for (int i = step; i <= step + nums[step]; i++) {
                if (i + nums[i] >= maxIndex + nums[maxIndex]){
                    maxIndex = i;
                }
            }
            if (nums[maxIndex] == 0){
                return false;
            }
            step = maxIndex;
        }
        return true;
    }
}
