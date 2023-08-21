package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 2475 数组中不等三元组的数目
 */
public class Test52 {
    @Test
    public void test(){
        int[] nums = {1,3,1,2,4};
        System.out.println(unequalTriplets(nums));
    }

    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        if (map.size() < 3){
            return 0;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            integers.add(entry.getValue());
        }
        int res = 0;
        for (int i = 0; i < integers.size()-2; i++) {
            for (int j = i+1; j < integers.size()-1; j++) {
                for (int k = j+1; k < integers.size(); k++) {
                    res += (integers.get(i)*integers.get(j)*integers.get(k));
                }
            }
        }
        return res;
    }
}
