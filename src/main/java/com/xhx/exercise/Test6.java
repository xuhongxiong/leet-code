package com.xhx.exercise;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * 提示：
 *
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 */
public class Test6 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long, Long> map = new HashMap<>();
        long w = t+1;
        for (int i = 0; i < nums.length; i++) {
            //分桶
            long num = nums[i];
            long id = getId(nums[i], w);
            //桶里有
            if (map.containsKey(id)){
                return true;
            }
            //前面桶满足
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w){
                return true;
            }
            //后面桶满足
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w){
                return true;
            }
            map.put(id,num);
            //删除距离超过k的数据
            if (i >= k){
                map.remove(getId(nums[i-k], w));
            }
        }
        return false;
    }

    private long getId(long num, long w){
        if (num >= 0){
            return num/w;
        }
        return (num+1)/w-1;
    }
}
