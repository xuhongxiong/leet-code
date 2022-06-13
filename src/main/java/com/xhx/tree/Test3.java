package com.xhx.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
 *
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 左 -> 右 ->根
 */
public class Test3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
}
