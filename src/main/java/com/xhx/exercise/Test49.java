package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 1090 受标签影响的最大值
 *
 * 我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还会给出两个整数 numWanted 和 useLimit 。
 *
 * 从 n 个元素中选择一个子集 s :
 *
 * 子集 s 的大小 小于或等于 numWanted 。
 * s 中 最多 有相同标签的 useLimit 项。
 * 一个子集的 分数 是该子集的值之和。
 *
 * 返回子集 s 的最大 分数 。
 *
 * 示例 1：
 *
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 *
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 *
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 * 提示：
 *
 * n == values.length == labels.length
 * 1 <= n <= 2 * 104
 * 0 <= values[i], labels[i] <= 2 * 104
 * 1 <= numWanted, useLimit <= n
 */
public class Test49 {

    @Test
    public void test(){
        int[] values = {9,8,8,7,6};
        int[] labels = {0,0,0,1,1};
        int numWanted = 3;
        int useLimit = 1;
        System.out.println(largestValsFromLabels(values,labels,numWanted,useLimit));
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int res = 0;
        Map<Integer, List<Integer>> valuesMap = new HashMap<>();
        List<Integer> valuesList = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            valuesMap.computeIfAbsent(values[i], integer -> new ArrayList<>()).add(i);
            valuesList.add(values[i]);
        }
        List<Integer> newValuesList = valuesList.stream().distinct().sorted((o1, o2) -> {
            if (o1 > o2) {
                return -1;
            } else if (o1 < o2) {
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        out: for (Integer integer : newValuesList) {
            List<Integer> integers = valuesMap.get(integer);
            for (Integer index : integers) {
                Integer labelNum = indexMap.getOrDefault(labels[index],0);
                if (numWanted == 0){
                    break out;
                }
                if (labelNum >= useLimit){
                    continue;
                }
                res += integer;
                numWanted--;
                if (labelNum > 0){
                    indexMap.put(labels[index],indexMap.get(labels[index])+1);
                } else {
                    indexMap.put(labels[index],1);
                }
            }
        }
        return res;
    }
}
