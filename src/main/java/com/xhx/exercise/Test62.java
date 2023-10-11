package com.xhx.exercise;

import com.xhx.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 449 序列化和反序列化二叉搜索树
 */
public class Test62 {
    @Test
    public void test(){
        TreeNode treeNode = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(serialize(treeNode));
        String serialize = serialize(treeNode);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(1);
    }

    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root,list);
        String str = list.toString();
        return str.substring(1,str.length()-1);
    }

    private void postOrder(TreeNode root,List<Integer> list){
        if (root == null){
            return;
        }
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] split = data.split(", ");
        Deque<Integer> stacks = new ArrayDeque<>();
        for (int i = 0; i < split.length; i++) {
            stacks.push(Integer.parseInt(split[i]));
        }
        return dfs(Integer.MIN_VALUE,Integer.MAX_VALUE,stacks);
    }

    private TreeNode dfs(int left,int right,Deque<Integer> stacks){
        if (stacks.isEmpty() || stacks.peek() < left || stacks.peek() > right){
            return null;
        }
        int val = stacks.pop();
        TreeNode treeNode = new TreeNode(val);
        treeNode.right = dfs(val,right,stacks);
        treeNode.left = dfs(left,val,stacks);
        return treeNode;
    }
}
