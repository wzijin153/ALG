package BinaryTree;

/**
 * @program: alghorithm
 * @description: 二叉树的最近公共祖先
 * @author: wangzijin
 * @create: 2024-04-06 14:00
 **/
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/

public class lowestCommonAncestor {
    public TreeNode method(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root, p, q);
    }

    // 从下往上处理二叉树, 一定是用后序遍历(回溯)
    TreeNode traverse(TreeNode root, TreeNode p, TreeNode q) {
        // root == q或者p, 说明找到 q p, 则将其返回
        if (root == null || root == p || root == q) return root;
        TreeNode left = traverse(root.left, p, q); // 判断左子树有没有出现过p ,q
        TreeNode right = traverse(root.right, p, q);
        // 1.左右子树都不为空, 说明都包含了p, q
        if (left != null && right != null) return root;
        if (left == null && right != null) return right;
        else if (left != null && right == null) return left;
        else return null;
    }
}