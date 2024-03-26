package BinaryTree;

import java.util.*;

/**
 * @program: alghorithm
 * @description: 二叉树的右试图
 * @author: wangzijin
 * @create: 2024-03-26 12:39
 **/
// https://leetcode.cn/problems/binary-tree-right-side-view/
// 层序遍历的时候，判断是否遍历到单层的最后面的元素. 如果是，就放进result数组中
public class rightSideView {
    public List<Integer> method(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        else queue.offer(root);
        while (!queue.isEmpty()) {
            // 取出每一层的节点个数
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // TODO (levelSize - 1)是当前层最后一个元素的下标, 如果i遍历到最后一个元素, 就加入到res数组中
                if (i == levelSize - 1) res.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}
