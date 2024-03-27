package BinaryTree;

/**
 * @program: alghorithm
 * @description: 对称二叉树
 * @author: wangzijin
 * @create: 2024-03-27 20:25
 **/
// https://leetcode.cn/problems/symmetric-tree/
public class isSymmetric {
    public boolean method(TreeNode root) {
        return compare(root.left, root.right);
    }

    // 是否对称 -> 左子树和右子树是否可以相互翻转 -> 外侧和外侧比较, 内侧和内侧比较
    // 后序遍历: 需要搜集左右节点的信息向根节点返回
    boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;
        // 比较外侧: 左节点的左孩子 vs 右节点的右孩子
        boolean outside = compare(left.left, right.right);
        // 比较内侧: 左节点的右孩子 vs 右节点的左孩子
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}