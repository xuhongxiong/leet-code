package com.xhx.hash;

import java.util.LinkedList;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 *
 * 0 <= key <= 106
 * 最多调用 104 次 add、remove 和 contains
 */
public class MyHashSet {
    private static final int size = 100;
    private LinkedList<Integer>[] map;

    private int hash(int key){
        return key%size;
    }

    public MyHashSet() {
        map = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            map[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        if (!map[hash].contains(key)){
            map[hash].add(key);
        }
    }

    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Integer> linkedList = map[hash];
        for (Integer integer : linkedList) {
            if (integer.equals(key)){
                linkedList.remove(integer);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        if (map[hash].contains(key)){
            return true;
        }
        return false;
    }
}
