package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer II 080 含有k个元素的组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例 1:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2:
 *
 * 输入: n = 1, k = 1
 * 输出: [[1]]
 * 提示:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Test34 {
    @Test
    public void test(){
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

    List<Integer> integers = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k,1);
        return res;
    }

    private void dfs(int n, int k, int startIndex) {
        if (integers.size() == k){
            res.add(new ArrayList<>(integers));
            return ;
        }
        for (int i = startIndex; n-i+1 >= k-integers.size(); i++) {
            integers.add(i);
            dfs(n,k,i+1);
            integers.remove(integers.size()-1);
        }
    }
}
