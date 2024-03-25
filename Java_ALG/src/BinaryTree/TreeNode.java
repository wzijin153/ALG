package BinaryTree;

/**
 * @program: alghorithm
 * @description: 定义二叉树
 * @author: wangzijin
 * @create: 2024-03-24 14:49
 **/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}