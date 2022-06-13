package com.xhx.tree;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Test6 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        } else if (root1 != null && root2 != null){
            return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left) && root1.val == root2.val;
        } else {
            return false;
        }
    }
}
