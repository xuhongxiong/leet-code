package com.xhx.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class Test4 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            List<Integer> itemList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                itemList.add(node.val);
                if (node.left != null){
                    linkedList.add(node.left);
                }
                if (node.right != null){
                    linkedList.add(node.right);
                }
            }
            res.add(itemList);
        }
        return res;
    }
}
