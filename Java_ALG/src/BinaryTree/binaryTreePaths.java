package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 二叉树的所有路径
 * @author: wangzijin
 * @create: 2024-03-29 22:34
 **/
// https://leetcode.cn/problems/binary-tree-paths/
public class binaryTreePaths {
    public List<String> method(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        preOrder(root, path, res);
        return res;
    }

    // 前序遍历
    void preOrder(TreeNode node, List<Integer> path, List<String> result) {
        // 处理根节点
        path.add(node.val);
        // 终止条件: 遍历到叶子节点时, 可以收获根节点到叶子节点的信息
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                builder.append(path.get(i)).append("->");
            }
            // 记录最后一个节点
            builder.append(path.get(path.size() - 1));
            result.add(builder.toString());
            return;
        }
        // 处理左节点
        if (node.left != null) {
            preOrder(node.left, path, result);
            // 回溯: 剔出最后一个元素
            path.remove(path.size() - 1);
        }
        // 处理右节点
        if (node.right != null) {
            preOrder(node.right, path, result);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}