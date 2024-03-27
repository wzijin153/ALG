package BinaryTree;

/**
 * @program: alghorithm
 * @description: 翻转二叉树
 * @author: wangzijin
 * @create: 2024-03-27 19:54
 **/
// https://leetcode.cn/problems/invert-binary-tree/description/
public class invertTree {
    public TreeNode method(TreeNode root) {
        invert(root);
        return root;
    }

    /*
        递归解法步骤:
        1.确定返回类型和参数
        2.确定递归终止条件
        3.处理递归中间逻辑
     */
    // 前序递归遍历
    TreeNode invert(TreeNode node) {
        if (node == null) return node;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invert(node.left);
        invert(node.right);
        return node;
    }
}