package com.xhx.tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 */
public class Test13 {
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root,res);
        return res.toString();
    }

    private void dfs(TreeNode root, StringBuilder res){
        if (root == null){
            res.append("#,");
            return;
        }
        res.append(root.val).append(",");
        dfs(root.left,res);
        dfs(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(split));
        return deDfs(linkedList);
    }

    private TreeNode deDfs(LinkedList<String> linkedList){
        if (linkedList.isEmpty()){
            return null;
        }
        String poll = linkedList.poll();
        if ("#".equals(poll)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(poll));
        node.left = deDfs(linkedList);
        node.right = deDfs(linkedList);
        return node;
    }
}
