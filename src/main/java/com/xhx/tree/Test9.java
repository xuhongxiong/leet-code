package com.xhx.tree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder和inorder均 无重复 元素
 * inorder均出现在preorder
 * preorder保证 为二叉树的前序遍历序列
 * inorder保证 为二叉树的中序遍历序列
 */
public class Test9 {
    @Test
    public void test(){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder,inorder));
    }

    int[] preorder;
    int[] inorder;
    int pre_index;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        pre_index = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(0,preorder.length-1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right){
            return null;
        }
        int mid = map.get(preorder[pre_index]);
        TreeNode node = new TreeNode(preorder[pre_index]);
        pre_index++;
        node.left = helper(left,mid-1);
        node.right = helper(mid+1,right);
        return node;
    }
}
