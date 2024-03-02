package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 46 全排列
 */
public class Test68 {
    @Test
    public void test(){
        int[] nums = {1,2,3};
        permute(nums);
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] bol = new boolean[nums.length];
        int[] res = new int[nums.length];
        dfs(nums,bol,res,0);
        return result;
    }

    private void dfs(int[] nums,boolean[] bol,int[] res,int index){
        if (index == nums.length){
            ArrayList<Integer> integers = new ArrayList<>();
            for (int re : res) {
                integers.add(re);
            }
            result.add(integers);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!bol[i]){
                res[index] = nums[i];
                bol[i] = true;
                dfs(nums,bol,res,index+1);
                bol[i] = false;
            }
        }
    }
}
