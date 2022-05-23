package com.xhx.queue;

import org.junit.Test;

import java.util.Stack;

/**
 * <p>Project: Test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class TestQueue1 {

    /**
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     * 输入：
     * ["MyQueue", "push", "push", "peek", "pop", "empty"]
     * [[], [1], [2], [], [], []]
     * 输出：
     * [null, null, null, 1, 1, false]
     *解释：
     * MyQueue myQueue = new MyQueue();
     * myQueue.push(1); // queue is: [1]
     * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
     * myQueue.peek(); // return 1
     * myQueue.pop(); // return 1, queue is [2]
     * myQueue.empty(); // return false
     */
    @Test
    public void test1() {

    }

    class MyQueue {
        Stack<Integer> reStack;//反序栈
        Stack<Integer> stack;//正序栈

        public MyQueue() {
            reStack = new Stack<Integer>();
            stack = new Stack<Integer>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            if (!reStack.isEmpty()){
                return reStack.pop();
            }
            while (!stack.isEmpty()){
                reStack.push(stack.pop());
            }
            return reStack.pop();
        }

        public int peek() {
            if (!reStack.isEmpty()){
                return reStack.peek();
            }
            while (!stack.isEmpty()){
                reStack.push(stack.pop());
            }
            return reStack.peek();
        }

        public boolean empty() {
            return reStack.isEmpty() && stack.isEmpty();
        }
    }
}
