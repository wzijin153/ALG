package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: alghorithm
 * @description: 合并二叉树
 * @author: wangzijin
 * @create: 2024-04-01 21:26
 **/
// https://leetcode.cn/problems/merge-two-binary-trees/description/
public class mergeTrees {
    public TreeNode method(TreeNode root1, TreeNode root2) {
        // 层次遍历, 以某一个二叉树为基准
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            if (node1.left == null && node2.left != null) node1.left = node2.left;
            if (node1.right == null && node2.right != null) node1.right = node2.right;
        }
        return root1;
    }

    // 递归, 前序遍历
    TreeNode mergeTree(TreeNode root1, TreeNode root2) {
        // 终止条件
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        // 单层递归逻辑
        root1.val += root2.val;// 中
        root1.left = mergeTree(root1.left, root2.left);// 左
        root1.right = mergeTree(root1.right, root2.right);// 右
        return root1;
    }
}