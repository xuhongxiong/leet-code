package com.xhx.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个 互不相同的整数数组，其中locations[i]表示第i个城市的位置。同时给你start，finish和fuel分别表示出发城市、目的地城市和你初始拥有的汽油总量
 *
 * 每一步中，如果你在城市 i，你可以选择任意一个城市 j，满足 j != i且0 <= j < locations.length，并移动到城市j。从城市i移动到j消耗的汽油量为|locations[i] - locations[j]|，|x|表示x的绝对值。
 *
 * 请注意，fuel任何时刻都不能为负，且你可以经过任意城市超过一次（包括start和finish）。
 *
 * 请你返回从start到finish所有可能路径的数目。
 *
 * 由于答案可能很大， 请将它对10^9 + 7取余后返回。
 *
 * 输入：locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
 * 输出：4
 * 解释：以下为所有可能路径，每一条都用了 5 单位的汽油：
 * 1 -> 3
 * 1 -> 2 -> 3
 * 1 -> 4 -> 3
 * 1 -> 4 -> 2 -> 3
 *
 * 2 <= locations.length <= 100
 * 1 <= locations[i] <= 109
 * 所有locations中的整数 互不相同。
 * 0 <= start, finish <locations.length
 * 1 <= fuel <= 200
 */
public class Test7 {
    @Test
    public void test(){
        int[] locations = {2,3,6,8,4};
        System.out.println(countRoutes(locations,1,3,5));
    }
    int MOD = 1000000007;
    //动态规划
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;

        // f[i][j] 代表从位置 i 出发，当前油量为 j 时，到达目的地的路径数
        int[][] f = new int[n][fuel + 1];

        // 对于本身位置就在目的地的状态，路径数为 1
        for (int i = 0; i <= fuel; i++) f[finish][i] = 1;

        // 从状态转移方程可以发现 f[i][fuel]=f[i][fuel]+f[k][fuel-need]
        // 在计算 f[i][fuel] 的时候依赖于 f[k][fuel-need]
        // 其中 i 和 k 并无严格的大小关系
        // 而 fuel 和 fuel-need 具有严格大小关系：fuel >= fuel-need
        // 因此需要先从小到大枚举油量
        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        int need = Math.abs(locations[i] - locations[k]);
                        if (cur >= need) {
                            f[i][cur] += f[k][cur-need];
                            f[i][cur] %= MOD;
                        }
                    }
                }
            }
        }
        return f[start][fuel];
    }
    //记忆化搜索
    /*int[][] f;//f[i][fuel] 代表从位置 i 出发，当前剩余的油量为 fuel 的前提下，到达目标位置的「路径数量」
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        f = new int[locations.length][fuel + 1];
        for (int[] ints : f) {
            Arrays.fill(ints,-1);
        }
        return dfs(locations,start,finish,fuel);
    }

    private int dfs(int[] locations, int pos, int finish, int reset){
        if (f[pos][reset] != -1){
            return f[pos][reset];
        }
        f[pos][reset] = 0;
        if (Math.abs(locations[pos]-locations[finish]) > reset){
            return 0;
        }
        // 计算油量为 fuel，从位置 pos 到 finish 的路径数量
        // 由于每个点都可以经过多次，如果 pos = finish，那么本身就算一条路径
        for (int i = 0; i < locations.length; i++) {
            if (pos != i){
                int cost;
                if ((cost = Math.abs(locations[pos]-locations[i])) <= reset){
                    f[pos][reset] += dfs(locations,i,finish,reset-cost);
                    f[pos][reset] %= MOD;
                }
            }
        }
        if (pos == finish){
            f[pos][reset] += 1;
            f[pos][reset] %= MOD;
        }
        return f[pos][reset];
    }*/
}
