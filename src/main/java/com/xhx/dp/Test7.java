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

    /*public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int ans = 0;
        int[][] dp = new int[fuel + 1][n];
        dp[0][start] = 1;
        for (int t = 1; t <= fuel; ++t) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if (i == j)
                        continue;
                    int cost = Math.abs(locations[i] - locations[j]);
                    if (t - cost >= 0) {
                        dp[t][i] = (int) (((long) dp[t][i] + dp[t -cost][j]) % 1000000007);
                    }
                }
            }
        }
        for (int t = 0; t <= fuel; ++t) {
            ans = (int) (((long) ans + dp[t][finish]) % 1000000007);
        }
        return ans;
    }*/
    int MOD = 1000000007;
    int[][] f;
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
    }

}
