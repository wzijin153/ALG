package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.cn/problems/find-bottom-left-tree-value/

/**
 * @program: alghorithm
 * @description: 找树左下角的值
 * @author: wangzijin
 * @create: 2024-03-30 13:41
 **/

public class findBottomLeftValue {
    public int method(TreeNode root) {
        // 层序遍历
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 只需要记录最后一行第一个节点的数值(左下角的值 -> 最后一层的第一个节点)
                if (i == 0) result = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }
    // 递归遍历:
}