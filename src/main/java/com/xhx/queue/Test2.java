package com.xhx.queue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Test2 {

    /**
     * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
     *
     * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
     *
     * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
     *
     * 输入：rooms = [[1],[2],[3],[]]
     * 输出：true
     * 解释：
     * 我们从 0 号房间开始，拿到钥匙 1。
     * 之后我们去 1 号房间，拿到钥匙 2。
     * 然后我们去 2 号房间，拿到钥匙 3。
     * 最后我们去了 3 号房间。
     * 由于我们能够进入每个房间，我们返回 true。
     */

    @Test
    public void test1() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList(0));
        boolean b = canVisitAllRooms(rooms);
        System.out.println(b);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Integer> integers = rooms.get(0);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(integers);
        boolean[] visitAble = new boolean[rooms.size()];
        visitAble[0] = true;
        while (!linkedList.isEmpty()) {
            Integer poll = linkedList.poll();
            if (!visitAble[poll]) {
                visitAble[poll] = true;
                List<Integer> newIntegers = rooms.get(poll);
                for (Integer newInteger : newIntegers) {
                    if (newInteger != null && !visitAble[newInteger]) {
                        linkedList.add(newInteger);
                    }
                }
            }
        }
        boolean result = true;
        for (boolean b : visitAble) {
            if (!b) {
                result = false;
                break;
            }
        }
        return result;
    }
}
