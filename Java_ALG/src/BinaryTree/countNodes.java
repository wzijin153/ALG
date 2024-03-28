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
        // 1.迭代法
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

    // 2.递归法
    int getCount(TreeNode node) {
        if (node == null) return 0;
        int leftCount = getCount(node.left);
        int rightCount = getCount(node.right);
        // 加1是因为算上当前中间节点
        return leftCount + rightCount + 1;
    }
}