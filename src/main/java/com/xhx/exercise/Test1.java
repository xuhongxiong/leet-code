package com.xhx.exercise;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Test1 {
    @Test
    public void test(){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,
                new ListNode(9,new ListNode(9,
                        new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(1))))))))));
        ListNode listNode = addTwoNumbers(l1, l2);
        int a = 1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder reverse1 = new StringBuilder(get(l1)).reverse();
        StringBuilder reverse2 = new StringBuilder(get(l2)).reverse();
        BigInteger resInt = new BigInteger(reverse1.toString()).add(new BigInteger(reverse2.toString()));
        StringBuilder resSb = new StringBuilder(resInt + "");
        char[] chars = resSb.reverse().toString().toCharArray();
        LinkedList<Character> characters = new LinkedList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        return set(characters);
    }

    private String get(ListNode node){
        if (node == null){
            return "";
        }
        return node.val + "" + get(node.next);
    }

    private ListNode set(LinkedList<Character> characters){
        if (characters.isEmpty()){
            return null;
        }
        Character poll = characters.poll();
        ListNode node = new ListNode(Integer.parseInt(String.valueOf(poll)));
        node.next = set(characters);
        return node;
    }
}
