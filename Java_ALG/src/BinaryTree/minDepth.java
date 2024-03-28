package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: alghorithm
 * @description: 二叉树的最小深度
 * @author: wangzijin
 * @create: 2024-03-27 16:14
 **/

public class minDepth {
    public int method(TreeNode root) {
        // 1.迭代法
        int minDepth = 0;
        if (root == null) return minDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //如果当前节点的左右孩子都为空，直接返回最小深度
                if (node.left == null && node.right == null) return minDepth;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return minDepth;
    }

    // 2.递归法, 后序遍历
    int getMinDepth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = getMinDepth(node.left);
        int rightDepth = getMinDepth(node.right);
        if (node.left == null && node.right != null) return rightDepth + 1;
        if (node.left != null && node.right == null) return leftDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }
}