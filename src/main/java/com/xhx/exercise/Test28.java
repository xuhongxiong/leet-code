package com.xhx.exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1654 到家的最小跳跃次数
 *
 * 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
 * 跳蚤跳跃的规则如下：
 * 它可以 往前 跳恰好 a 个位置（即往右跳）。
 * 它可以 往后 跳恰好 b 个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何 forbidden 数组中的位置。
 * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 *
 * 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
 *
 * 输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9 输出：3 解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
 *
 * 提示：
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * forbidden 中所有位置互不相同。
 * 位置 x 不在 forbidden 中。
 */
public class Test28 {
    @Test
    public void test(){
        int[] forbidden = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
        System.out.println((minimumJumps(forbidden,29,98,80)));
    }

    int[] dis;
    boolean[] vis;//已走过
    Set<Integer> forbiddenSet;
    int rightMax;//右侧临界位置
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
//        Arrays.sort(forbidden);
//        rightMax = Math.max((forbidden[forbidden.length-1]+a+b),x+b);
        rightMax = 6000;
        dis = new int[rightMax];
        vis = new boolean[rightMax];
        Arrays.fill(dis,Integer.MAX_VALUE);
        forbiddenSet = new HashSet<>();
        for (int i : forbidden) {
            forbiddenSet.add(i);
        }
        bfs(0,x,a,b);
        return dis[x] == Integer.MAX_VALUE ? -1 : dis[x];
    }

    private void bfs(int start,int end,int a,int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,0});//start代表位置，0：前一步前进，1：前一步后退
        vis[start] = true;
        dis[start] = 0;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            if (cur[0] == end){
                return;
            }
            //前进
            if (cur[0]+a < rightMax && !forbiddenSet.contains(cur[0]+a) && !vis[cur[0]+a]){
                if (dis[cur[0]]+1 < dis[cur[0]+a]){
                    dis[cur[0]+a] = dis[cur[0]]+1;
                }
                vis[cur[0]+a] = true;
                queue.offer(new int[]{cur[0]+a,0});
            }
            //后退 因为不能连续后退两步
            if (cur[1] == 0 && cur[0]-b >= 0 && !forbiddenSet.contains(cur[0]-b) && !vis[cur[0]-b]){
                if (dis[cur[0]]+1 < dis[cur[0]-b]){
                    dis[cur[0]-b] = dis[cur[0]]+1;
                }
                //vis[cur[0]+a] = true;后退到的点跟前进的点是不一样的
                queue.offer(new int[]{cur[0]-b,1});
            }
        }
    }
}
