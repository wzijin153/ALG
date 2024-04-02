package BinaryTree;


/**
 * @program: alghorithm
 * @description: 验证二叉搜索树
 * @author: wangzijin
 * @create: 2024-04-02 22:18
 **/
// https://leetcode.cn/problems/validate-binary-search-tree/description/
public class isValidBST {
    TreeNode pre = null; // 用来记录前一个节点

    public boolean method(TreeNode root) {
        return traversal(root);
    }

    // 递归, 中序遍历, 元素值是单调递增的(双指针法)
    boolean traversal(TreeNode root) {
        if (root == null) return true;
        boolean left = traversal(root.left);
        // 二叉搜索树的val值是递增的, 如果前一个节点的val值大于等于当前节点的val, 则不是二叉树
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        boolean right = traversal(root.right);
        return left && right;
    }
}