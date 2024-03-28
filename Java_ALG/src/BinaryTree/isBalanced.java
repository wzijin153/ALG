package BinaryTree;

/**
 * @program: alghorithm
 * @description: 平衡二叉树
 * @author: wangzijin
 * @create: 2024-03-28 15:27
 **/
// https://leetcode.cn/problems/balanced-binary-tree/
public class isBalanced {
    public boolean method(TreeNode root) {
        if (root == null) return true;
        return getHeight(root) != -1;
    }

    int getHeight(TreeNode node) {
        if (node == null) return 0;
        // 1.分别求出其左右子树的高度
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;
        // 2.是平衡二叉树再返回, 不是就不用返回, 用 -1 来标记不符合平衡二叉树的规则
//        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
//        else return Math.max(leftHeight, rightHeight) + 1;
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
