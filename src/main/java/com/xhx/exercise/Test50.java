package com.xhx.exercise;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1377 T秒后青蛙的位置
 *
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 *
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。
 *
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10-5 的结果将被视为正确答案。
 *
 * 示例 1：
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * 输出：0.16666666666666666
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，
 * 因此青蛙在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
 *
 * 提示：
 *
 * 1 <= n <= 100
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ai, bi <= n
 * 1 <= t <= 50
 * 1 <= target <= n
 * Related Topics
 * 树
 * 深度优先搜索
 * 广度优先搜索
 * 图
 */
public class Test50 {

    @Test
    public void test(){
        int n = 34;
        //int[][] edges = new int[][]{{2,1},{3,2}};
        //int[][] edges = new int[][]{{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        //int[][] edges = new int[][]{{2,1},{3,2},{4,1},{5,3},{6,1},{7,2},{8,5},{9,7},{10,4},{11,8},{12,2},{13,11},{14,7},{15,5},{16,9},{17,16},{18,1},{19,11},{20,13},{21,10},{22,1},{23,6},{24,7},{25,11},{26,19},{27,26},{28,5},{29,11},{30,14},{31,7},{32,9},{33,7},{34,25},{35,23},{36,35},{37,32},{38,35},{39,16},{40,5},{41,3},{42,6},{43,9},{44,11},{45,11},{46,35},{47,14},{48,18},{49,22},{50,39}};
        int[][] edges = new int[][]{{2,1},{3,2},{4,1},{5,3},{6,2},{7,5},{8,7},{9,8},{10,3},{11,10},{12,9},{13,2},{14,6},{15,1},{16,7},{17,3},{18,13},{19,5},{20,5},{21,11},{22,4},{23,20},{24,19},{25,13},{26,3},{27,19},{28,18},{29,8},{30,19},{31,3},{32,31},{33,18},{34,24}};
        int t = 19;
        int target = 8;
        System.out.println(frogPosition(n,edges,t,target));
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        LinkedList<List<Step>> linkedList = new LinkedList<>();
        linkedList.push(Collections.singletonList(new Step(1, 1d, new HashSet<>())));
        while (!linkedList.isEmpty()){
            if (t == 0){
                break;
            }
            List<Step> stepList = linkedList.poll();
            ArrayList<Step> steps = new ArrayList<>();
            for (Step step : stepList) {
                int poll = step.getIndex();
                double value = step.getValue();
                Set<Integer> integerSet = step.getIntegers();
                List<Integer> integers = map.get(poll);
                List<Integer> collect = integers.stream().filter(o -> !integerSet.contains(o)).collect(Collectors.toList());
                if (collect.size() == 0){
                    steps.add(new Step(poll,value,integerSet));
                } else {
                    integerSet.add(poll);
                    for (Integer integer : collect) {
                        steps.add(new Step(integer,value*(1.0/collect.size()),integerSet));
                    }
                }
            }
            linkedList.add(steps);
            t--;
        }
        double res = 0;
        for (List<Step> steps : linkedList) {
            for (Step step : steps) {
                if (step.getIndex() == target){
                    double tDouble = step.getValue();
                    res += tDouble;
                }
            }
        }
        return res;
    }

    class Step{
        private int index;
        private double value;
        private Set<Integer> integers;

        public Step(int index, double value, Set<Integer> integers) {
            this.index = index;
            this.value = value;
            this.integers = integers;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public Set<Integer> getIntegers() {
            return integers;
        }

        public void setIntegers(Set<Integer> integers) {
            this.integers = integers;
        }
    }
}
