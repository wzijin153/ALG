package BinaryTree;

/**
 * @program: alghorithm
 * @description: 删除二叉搜索树中的节点
 * @author: wangzijin
 * @create: 2024-04-06 16:12
 **/
// https://leetcode.cn/problems/delete-node-in-a-bst/
/*
    1.树中不存在值为key的节点
    2.存在:
        1).删除节点是叶子节点
        2).删除节点左不空右为空
        3).删除节点左为空右不空
        4).删除节点左不空右不空
 */

public class deleteNode {
    public TreeNode method(TreeNode root, int key) {
        return delete(root, key);
    }

    TreeNode delete(TreeNode root, int key) {
        // 终止条件: 树中不存在值为key的节点
        if (root == null) return null;
        if (root.val == key) {
            // 1).删除节点是叶子节点
            if (root.left == null && root.right == null) return null;
                // 2).删除节点左不空右为空
            else if (root.left != null && root.right == null) return root.left;
                // 3).删除节点左为空右不空
            else if (root.left == null && root.right != null) return root.right;
            else {
                // 4).删除节点左不空右不空
                TreeNode cur = root.right;
                while (cur.left != null) cur = cur.left; // 找右子树最左面的节点
                cur.left = root.left;
                return root.right; // 返回旧root的右孩子作为新root
            }
        }
        // 单层递归逻辑
        if (key < root.val) root.left = delete(root.left, key);
        else root.right = delete(root.right, key);
        return root;
    }
}