package BinaryTree;

import java.util.*;

/**
 * @program: alghorithm
 * @description: 在每个树行中寻找最大值
 * @author: wangzijin
 * @create: 2024-03-26 12:39
 **/

public class largestValues {
    public List<Integer> method(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        else queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 用于记录当前层的最大值
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 更新当前层的最大值
                maxValue = Math.max(maxValue, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(maxValue);
        }
        return res;
    }
}
