package com.xhx.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder和postorder都由 不同 的值组成
 * postorder中每一个值都在inorder中
 * inorder保证是树的中序遍历
 * postorder保证是树的后序遍历
 */
public class Test8 {
    int[] inorder;
    int[] postorder;
    int post_index;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        post_index = inorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(0,post_index);
    }

    private TreeNode helper(int left, int right) {
        if (left > right){
            return null;
        }
        Integer mid = map.get(postorder[post_index]);
        TreeNode root = new TreeNode(postorder[post_index]);
        post_index--;
        root.right = helper(mid+1,right);
        root.left = helper(left,mid-1);
        return root;
    }
}
