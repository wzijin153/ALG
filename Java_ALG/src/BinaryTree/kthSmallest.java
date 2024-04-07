package BinaryTree;

/**
 * @program: alghorithm
 * @description: 二叉搜索树中第K小的元素
 * @author: wangzijin
 * @create: 2024-04-07 20:35
 **/
// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
public class kthSmallest {
    int cnt = 0, res = 0;

    public int method(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        cnt++;
        if (cnt == k) res = root.val;
        traverse(root.right, k);
    }
}