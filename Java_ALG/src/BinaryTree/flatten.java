package BinaryTree;

/**
 * @program: alghorithm
 * @description: 二叉树展开为链表
 * @author: wangzijin
 * @create: 2024-04-07 20:47
 **/
//https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-100-liked
public class flatten {
    TreeNode pre = null;

    public void method(TreeNode root) {
        transform(root);
    }

    void transform(TreeNode root) {
        if (root == null) return;
        // 保存节点信息
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 一次处理一个节点, 用双指针
        if (pre != null) {
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        transform(left);
        transform(right);
    }
}