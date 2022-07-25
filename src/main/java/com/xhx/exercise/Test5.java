package com.xhx.exercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 现有一个房间，墙上挂有 n 只已经打开的灯泡和 4 个按钮。在进行了 m 次未知操作后，你需要返回这 n 只灯泡可能有多少种不同的状态。
 *
 * 假设这 n 只灯泡被编号为 [1, 2, 3 ..., n]，这 4 个按钮的功能如下：
 *
 * 将所有灯泡的状态反转（即开变为关，关变为开）
 * 将编号为偶数的灯泡的状态反转
 * 将编号为奇数的灯泡的状态反转
 * 将编号为 3k+1 的灯泡的状态反转（k = 0, 1, 2, ...)
 * 示例 1:
 *
 * 输入: n = 1, m = 1.
 * 输出: 2
 * 说明: 状态为: [开], [关]
 *
 * 注意： n 和 m 都属于 [0, 1000].
 */
public class Test5 {

    public int flipLights(int n, int presses) {
        n = Math.min(n,3);
        if (presses == 0) return 1;
        if (presses == 1) return n == 1 ? 2 : n == 2 ? 3 : 4;
        if (presses == 2) return n == 1 ? 2 : n == 2 ? 4 : 7;
        return n == 1 ? 2 : n == 2 ? 4 : 8;
    }
}
