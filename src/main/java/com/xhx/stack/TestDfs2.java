package com.xhx.stack;

import org.junit.Test;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class TestDfs2 {

    @Test
    public void test1(){
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums,target));
    }

    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     *
     * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     *
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
     * 输入：nums = [1,1,1,1,1], target = 3
     * 输出：5
     * 解释：一共有 5 种方法让最终目标和为 3
     * @param target
     * @return
     */


    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,0,target,0);
        return count;
    }

    public int count;

    private void dfs(int[] nums, int index, int target, int current) {
        if (index == nums.length){
            if (target == current){
                count++;
            }
            return;
        }
        dfs(nums,index+1,target,current+nums[index]);
        dfs(nums,index+1,target,current-nums[index]);
    }
}
