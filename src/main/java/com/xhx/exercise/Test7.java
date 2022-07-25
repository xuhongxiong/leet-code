package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 示例 1:
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 示例 3：
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *
 * 提示：
 * 1 <= houses.length, heaters.length <= 3 * 104
 * 1 <= houses[i], heaters[i] <= 109
 */
public class Test7 {
    @Test
    public void test(){
        int[] houses = {1,2,3};
        int[] heaters = {2};
        System.out.println(findRadius(houses,heaters));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int min = Math.min(leftDistance, rightDistance);
            res = Math.max(min,res);
        }
        return res;
    }

    private int binarySearch(int[] heaters, int target) {
        int left = 0;
        int right = heaters.length-1;
        if (heaters[left] > target){
            return -1;
        }
        while (left < right){
            int mid = left + ((right-left+1) >> 1);
            if (heaters[mid] == target){
                return mid;
            } else if (heaters[mid] > target){
                right = mid -1 ;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
