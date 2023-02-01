package com.xhx.exercise;

import com.xhx.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 *
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 *
 * 示例 3:
 * 输入: []
 * 输出: []
 * 提示:
 *
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class Test31 {
    @Test
    public void test(){
        TreeNode node = new TreeNode(1, new TreeNode(2,null,new TreeNode(5)),
                new TreeNode(3,null,new TreeNode(4)));
        List<Integer> integers = rightSideView(node);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean out = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null){
                    if (node.right != null){
                        queue.add(node.right);
                    }
                    if (node.left != null){
                        queue.add(node.left);
                    }
                    if (!out){
                        res.add(node.val);
                        out = true;
                    }
                }
            }
        }
        return res;
    }
}
