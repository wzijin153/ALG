package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: alghorithm
 * @description: 二叉树的最大深度
 * @author: wangzijin
 * @create: 2024-03-28 15:06
 **/
// https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
public class maxDepth {
    public int method(TreeNode root) {
        int maxDepth = 0;
        if (root == null) return maxDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return maxDepth;
    }

    // 递归解法, 后序遍历
    int getMaxDepth(TreeNode node) {
        if (node == null) return 0;
        // 1.先求左子树的深度
        int leftDepth = getMaxDepth(node.left);
        // 2.再求右子树的深度
        int rightDepth = getMaxDepth(node.right);
        // 3.取左右深度最大的数值 再 +1 （加1是因为算上当前中间节点）
        return Math.max(leftDepth, rightDepth) + 1;
    }
}