package com.xhx.hash;

import java.util.LinkedList;

/**
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 */
public class MyHashMap {
    private static final int size = 100;
    private LinkedList<Node>[] map;

    private int hash(int key){
        return key%size;
    }

    public MyHashMap() {
        map = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            map[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Node> nodes = map[hash];
        for (Node node : nodes) {
            if (node.key == key){
                node.value = value;
                return;
            }
        }
        nodes.add(new Node(key,value));
    }

    public int get(int key) {
        int hash = hash(key);
        LinkedList<Node> nodes = map[hash];
        for (Node node : nodes) {
            if (node.key == key){
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Node> nodes = map[hash];
        for (Node node : nodes) {
            if (node.key == key){
                nodes.remove(node);
                return;
            }
        }
    }

    class Node{
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
