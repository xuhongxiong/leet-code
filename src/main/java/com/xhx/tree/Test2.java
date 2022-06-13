package com.xhx.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 中序 遍历。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 左 -> 根 ->右
 */
public class Test2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }
}
