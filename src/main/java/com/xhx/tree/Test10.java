package com.xhx.tree;

import java.util.LinkedList;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 * 树中节点的数量在 [0, 212 - 1] 范围内
 * -1000 <= node.val <= 1000
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Test10 {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                Node poll = linkedList.poll();
                if (i < size-1){
                    poll.next = linkedList.peek();
                }
                if (poll.left != null){
                    linkedList.add(poll.left);
                }
                if (poll.right != null){
                    linkedList.add(poll.right);
                }
            }
        }
        return root;
    }
}
