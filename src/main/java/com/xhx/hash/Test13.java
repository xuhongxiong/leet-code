package com.xhx.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * <p>
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * <p>
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
 */
public class Test13 {
    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    private String serialize(TreeNode root){
        if (root == null){
            return "#";
        }
        String serialize = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        map.put(serialize,map.getOrDefault(serialize,0) + 1);
        if (map.get(serialize) == 2){
            res.add(root);
        }
        return serialize;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
