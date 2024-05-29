package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: alghorithm
 * @description: 完全二叉树节点的个数
 * @author: wangzijin
 * @create: 2024-03-28 15:27
 **/
// https://leetcode.cn/problems/count-complete-tree-nodes/
public class countNodes {
    public int method(TreeNode root) {
        /**
         * 1.迭代法
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        int count = 0;
        if (root == null) return count;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        count++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    count++;
                }
                // 这里不能用else if, 如果节点有左子节点，则右子节点的计数就不会被执行。这会导致只有当节点没有左子节点时，才会对右子节点进行计数
                // 使用独立的 if, 无论节点是否有左子节点或右子节点，都会对计数进行增加
                if (node.right != null) {
                    queue.offer(node.right);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 2.递归法
     * 时间复杂度：O(n)
     * 空间复杂度：O(log n), 算上了递归系统栈占用的空间
     */
    int getCount(TreeNode node) {
        if (node == null) return 0;
        int leftCount = getCount(node.left);
        int rightCount = getCount(node.right);
        // 加1是因为算上当前中间节点
        return leftCount + rightCount + 1;
    }

    /**
     * 3.利用完全二叉树和满二叉树的性质
     * 时间复杂度：O(log n * log n)
     * 空间复杂度：O(log n)
     */
    int getNum(TreeNode node) {
        if (node == null) return 0;
        // 开始根据左深度和右深度是否相同来判断该子树是不是满二叉树
        TreeNode left = node.left, right = node.right;
        int leftDepth = 0, rightDepth = 0;
        // 求左子树深度
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        // 求右子树深度
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        // 满二叉树的结点数为：2^depth - 1
        if (leftDepth == rightDepth) return (2 << leftDepth) - 1;
        int leftNum = getNum(node.left);
        int rightNum = getNum(node.right);
        return leftNum + rightNum + 1;
    }
}