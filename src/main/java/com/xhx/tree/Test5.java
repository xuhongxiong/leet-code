package com.xhx.tree;

import org.junit.Test;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 返回它的最大深度 3 。
 */
public class Test5 {
    /*int res = 0;
    public int maxDepth(TreeNode root) {
        depth(root,1);
        return res;
    }


    private void depth(TreeNode root, int depth) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            res = Math.max(res,depth);
        }
        depth(root.left,depth + 1);
        depth(root.right,depth + 1);
    }*/
    @Test
    public void test(){
        TreeNode root = new TreeNode(1,new TreeNode(2,null,null),null);
        System.out.println(maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
