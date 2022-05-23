package com.xhx.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>Project: Test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class TestStack1 {
    /**
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     * 输入：
     * ["MyStack", "push", "push", "top", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 2, 2, false]
     *
     * 解释：
     * MyStack myStack = new MyStack();
     * myStack.push(1);
     * myStack.push(2);
     * myStack.top(); // 返回 2
     * myStack.pop(); // 返回 2
     * myStack.empty(); // 返回 False
     */

    class MyStack {
        Queue<Integer> oneQueue;
        Queue<Integer> twoQueue;

        public MyStack() {
            oneQueue = new ArrayDeque<Integer>();
            twoQueue = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            if (twoQueue.isEmpty()){
                oneQueue.add(x);
            } else {
                twoQueue.add(x);
            }
        }

        public int pop() {
            if (twoQueue.isEmpty()){
                while (oneQueue.size() != 1){
                    twoQueue.add(oneQueue.poll());
                }
                return oneQueue.poll();
            } else {
                while (twoQueue.size() != 1){
                    oneQueue.add(twoQueue.poll());
                }
                return twoQueue.poll();
            }
        }

        public int top() {
            int res;
            if (twoQueue.isEmpty()){
                while (oneQueue.size() != 1){
                    twoQueue.add(oneQueue.poll());
                }
                res = oneQueue.poll();
                twoQueue.add(res);
            } else {
                while (twoQueue.size() != 1){
                    oneQueue.add(twoQueue.poll());
                }
                res = twoQueue.poll();
                oneQueue.add(res);
            }
            return res;
        }

        public boolean empty() {
            return oneQueue.isEmpty() && twoQueue.isEmpty();
        }
    }
}
