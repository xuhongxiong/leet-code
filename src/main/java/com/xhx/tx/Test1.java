package com.xhx.tx;

import org.junit.Test;

/**
 * 跳跃游戏II
 */
public class Test1 {
    @Test
    public void test(){
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
        int res = 0;
        int step = 0;
        while (step < nums.length-1){
            int maxIndex = 0;
            res++;
            if (step + nums[step] >= nums.length-1){
                break;
            }
            for (int i = step + 1; i <= step + nums[step]; i++) {
                if (i + nums[i] > maxIndex + nums[maxIndex]){
                    maxIndex = i;
                }
            }
            step = maxIndex;
        }
        return res;
    }
}
