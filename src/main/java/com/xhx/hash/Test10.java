package com.xhx.hash;

import com.sun.xml.internal.bind.v2.util.StackRecorder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
public class Test10 {
    @Test
    public void test(){
        int[] nums = {99,99};
        System.out.println(containsNearbyDuplicate(nums,2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                Integer integer = map.get(nums[i]);
                if (i - integer <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
