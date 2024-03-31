package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 路径总和II
 * @author: wangzijin
 * @create: 2024-03-30 22:44
 **/

public class pathSum {
    public List<List<Integer>> method(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayList<Integer> path = new ArrayList<>();
        traverse(root, targetSum, res, path);
        return res;
    }

    void traverse(TreeNode node, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(node.val);
        if (node.left == null && node.right == null && targetSum - node.val == 0) {
            res.add(new ArrayList<>(path));
        }
        if (node.left != null) {
            traverse(node.left, targetSum - node.val, res, path);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            traverse(node.right, targetSum - node.val, res, path);
            path.remove(path.size() - 1);
        }
    }
}