package com.xhx.efcz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length<= 104
 * arr按 升序 排列
 * -104<= arr[i], x <= 104
 */
public class Test9 {
    @Test
    public void test(){
        /*int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;*/
        /*int[] arr = {1};
        int k = 1;
        int x = 1;*/
        /*int[] arr = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;*/
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        int k = 3;
        int x = 5;
        System.out.println(Arrays.toString(findClosestElements(arr,k,x).toArray()));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>();
        if (k == arr.length){
            for (int i : arr) {
                results.add(i);
            }
            return results;
        }
        int left = 0;
        int right = arr.length-k;
        while (left+1 < right){
            int mid = left + ((right-left) >>>1);
            if (x-arr[mid] > arr[mid+k]-x){
                left = mid;
            } else {
                right = mid;
            }
        }

        if (x-arr[left] <= arr[left+k]-x){
            for (int i = 0; i < k; i++) {
                results.add(arr[left+i]);
            }
        } else {
            for (int i = 0; i < k; i++) {
                results.add(arr[right+i]);
            }
        }
        return results;
    }
}
