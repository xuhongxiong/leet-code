package com.xhx.exercise;

import org.junit.Test;

/**
 * 1510 石子游戏
 * Alice 和 Bob 两个人轮流玩一个游戏，Alice 先手。
 *
 * 一开始，有 n 个石子堆在一起。每个人轮流操作，正在操作的玩家可以从石子堆里拿走 任意 非零 平方数 个石子。
 *
 * 如果石子堆里没有石子了，则无法操作的玩家输掉游戏。
 *
 * 给你正整数 n ，且已知两个人都采取最优策略。如果 Alice 会赢得比赛，那么返回 True ，否则返回 False 。
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：Alice 拿走 1 个石子并赢得胜利，因为 Bob 无法进行任何操作。
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 * 解释：Alice 只能拿走 1 个石子，然后 Bob 拿走最后一个石子并赢得胜利（2 -> 1 -> 0）。
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：true
 * 解释：n 已经是一个平方数，Alice 可以一次全拿掉 4 个石子并赢得胜利（4 -> 0）。
 * 示例 4：
 *
 * 输入：n = 7
 * 输出：false
 * 解释：当 Bob 采取最优策略时，Alice 无法赢得比赛。
 * 如果 Alice 一开始拿走 4 个石子， Bob 会拿走 1 个石子，然后 Alice 只能拿走 1 个石子，Bob 拿走最后一个石子并赢得胜利（7 -> 3 -> 2 -> 1 -> 0）。
 * 如果 Alice 一开始拿走 1 个石子， Bob 会拿走 4 个石子，然后 Alice 只能拿走 1 个石子，Bob 拿走最后一个石子并赢得胜利（7 -> 6 -> 2 -> 1 -> 0）。
 * 示例 5：
 *
 * 输入：n = 17
 * 输出：false
 * 解释：如果 Bob 采取最优策略，Alice 无法赢得胜利。
 * 提示：
 *
 * 1 <= n <= 10^5
 */
public class Test20 {

    /**
     * dp五部曲
     * 状态定义：f[i]代表剩余石头为i时，必赢为true，反之false
     * 状态转移：f[i]赢得游戏，那就需要f[i-j*j]为false，一旦f[i-j*j]为false，则break
     * 初始化：f[0]为false
     * 遍历顺序：先遍历i，再遍历j，f[i]依赖于前面的状态，正序遍历
     * 返回形式：f[n]
     *
     */
    @Test
    public void test() {
        System.out.println(winnerSquareGame(4));
    }

    public boolean winnerSquareGame(int n) {
        boolean[] f = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!f[i - j * j]){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
