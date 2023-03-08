package com.xhx.exercise;

import com.xhx.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer 049 从根节点到叶节点的路劲数字之和
 */
public class Test37 {
    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(sumNumbers(treeNode));
    }

    private int res = 0;
    private List<String> strings = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfsTree(root,new StringBuilder());
        return res;
    }

    private void dfsTree(TreeNode root, StringBuilder num){
        if (root == null){
            return;
        }
        num.append(root.val);
        int length = num.length();
        if (root.left == null && root.right == null){
            strings.add(num.toString());
            res += Integer.parseInt(num.toString());
            return;
        }
        if (root.left != null){
            dfsTree(root.left,num);
            num = new StringBuilder(num.substring(0, length));
        }
        if (root.right != null){
            dfsTree(root.right,num);
        }
    }
}
