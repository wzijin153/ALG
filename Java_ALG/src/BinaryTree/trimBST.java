package BinaryTree;

/**
 * @program: alghorithm
 * @description: 修剪二叉搜索树
 * @author: wangzijin
 * @create: 2024-04-06 17:37
 **/

public class trimBST {
    public TreeNode method(TreeNode root, int low, int high) {
        return traverse(root, low, high);
    }

    TreeNode traverse(TreeNode root, int low, int high) {
        // 终止条件
        if (root == null) return null;
        if (root.val < low) {
            TreeNode right = traverse(root.right, low, high);
            return right;
        }
        if (root.val > high) {
            TreeNode left = traverse(root.left, low, high);
            return left;
        }
        root.left = traverse(root.left, low, high);
        root.right = traverse(root.right, low, high);
        return root;
    }
}