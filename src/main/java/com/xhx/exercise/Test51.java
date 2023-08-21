package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 2455 可被三整除的偶数的平均值
 */
public class Test51 {
    @Test
    public void test(){
        int[] nums = {1,3,6,10,12,15};
        System.out.println(averageValue(nums));
    }

    public int averageValue(int[] nums) {
        ArrayList<Integer> resList = new ArrayList<>();
        for (int num : nums) {
            if (num % 6 == 0){
                resList.add(num);
            }
        }
        if (resList.size() == 0){
            return 0;
        }
        int sum = 0;
        for (Integer integer : resList) {
            sum += integer;
        }
        return sum / resList.size();
    }
}
