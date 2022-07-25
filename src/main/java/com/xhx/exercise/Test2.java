package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test2 {
    @Test
    public void test(){
        /*int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));*/

        int[] nums = {4,4,7,6,7};
        System.out.println(minSubsequence(nums));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0){
                res |= (1 << i);
            }
        }
        return res;
    }

    public List<Integer> minSubsequence(int[] nums) {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int num : nums) {
            integers.add(num);
        }
        integers.sort(Comparator.reverseOrder());
        List<Integer> res = new ArrayList<>();
        while (!integers.isEmpty()){
            Integer pop = integers.pop();
            res.add(pop);
            if (res.stream().mapToInt(Integer::intValue).sum() > integers.stream().mapToInt(Integer::intValue).sum()){
                break;
            }
        }
        return res;
    }
}


