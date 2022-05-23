package com.xhx.stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>Project: Test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class TestDfs1 {

    @Test
    public void test1() {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2,new TreeNode(3),null));
        List<Integer> integers = inorderTraversal(treeNode);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        while (root != null || !stack.isEmpty()){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = pop.right;
        }
        return res;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
