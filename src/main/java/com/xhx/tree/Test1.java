package com.xhx.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 根 -> 左 ->右
 */
public class Test1 {
    @Test
    public void test(){
        TreeNode node = new TreeNode(1, new TreeNode(3, new TreeNode(5),new TreeNode(6)),new TreeNode(2));
        List<Integer> integers = preorderTraversal(node);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null){
            return;
        }
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
}
