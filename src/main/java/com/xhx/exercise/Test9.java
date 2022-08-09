package com.xhx.exercise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表最大孪生和
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
 *
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 *
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 *
 * 输入：head = [5,4,2,1] 输出：6 解释： 节点 0 和节点 1 分别是节点 3 和 2 的孪生节点。孪生和都为 6 。 链表中没有其他孪生节点。 所以，链表的最大孪生和是 6 。
 */
public class Test9 {
    @Test
    public void test(){
        ListNode listNode = new ListNode(1,new ListNode(10000));
        System.out.println(pairSum(listNode));
    }

    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size()-1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < (list.size()>>1); i++) {
            int value = list.get(left + i) + list.get(right-left - i);
            if (res < value) res = value;
        }
        return res;
    }
}
