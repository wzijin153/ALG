package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: alghorithm
 * @description: 二叉树的最大深度
 * @author: wangzijin
 * @create: 2024-03-27 16:06
 **/

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
}