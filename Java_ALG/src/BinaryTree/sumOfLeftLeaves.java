package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: alghorithm
 * @description: 左叶子之和
 * @author: wangzijin
 * @create: 2024-03-30 12:54
 **/
// https://leetcode.cn/problems/sum-of-left-leaves/
public class sumOfLeftLeaves {
    public int method(TreeNode root) {
        // 层序遍历
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.left == null && node.left.right == null) sum += node.left.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return sum;
    }

    // 递归: 后序遍历
    int sumLeftLeaves(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        int leftSum = sumLeftLeaves(node.left);// 左
        // 要通过节点的父节点来判断, 如果到叶子节点才进行处理, 则无法判断是否是左叶子节点
        // 左叶子: 节点A的左孩子不为空，且左孩子的左右孩子都为空
        if (node.left != null && node.left.left == null && node.left.right == null) leftSum = node.left.val;
        int rightSum = sumLeftLeaves(node.right);// 右
        return leftSum + rightSum;// 根
    }
}