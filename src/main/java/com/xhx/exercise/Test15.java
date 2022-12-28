package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 2150找出数组中所有的孤独数字
 * 给你一个整数数组 nums 。如果数字 x 在数组中仅出现 一次 ，且没有 相邻 数字（即，x + 1 和 x - 1）出现在数组中，则认为数字 x 是 孤独数字 。
 *
 * 返回 nums 中的 所有 孤独数字。你可以按 任何顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [10,6,5,8]
 * 输出：[10,8]
 * 解释：
 * - 10 是一个孤独数字，因为它只出现一次，并且 9 和 11 没有在 nums 中出现。
 * - 8 是一个孤独数字，因为它只出现一次，并且 7 和 9 没有在 nums 中出现。
 * - 5 不是一个孤独数字，因为 6 出现在 nums 中，反之亦然。
 * 因此，nums 中的孤独数字是 [10, 8] 。
 * 注意，也可以返回 [8, 10] 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 106
 */
public class Test15 {
    @Test
    public void test(){
        int[] nums = {10,6,5,8};
        List<Integer> lonely = findLonely(nums);
        System.out.println(Arrays.toString(lonely.toArray()));
    }

    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1 && map.get(num-1) == null && map.get(num+1) == null){
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(6);
        integers.remove(new Integer(4));
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        int[] nums = {1,2};
        String[] strArr = {"1","2"};
        List<String> stringList = Arrays.asList(strArr);
        System.out.println();

    }
}
