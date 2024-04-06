package BinaryTree;

/**
 * @program: alghorithm
 * @description: 二叉搜索树的最小绝对差
 * @author: wangzijin
 * @create: 2024-04-02 23:13
 **/
// https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
public class getMinimumDifference {
    int minValue = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int method(TreeNode root) {
        traverse(root);
        return minValue;
    }

    // 前序遍历
    void traverse(TreeNode cur) {
        if (cur == null) return;
        traverse(cur.left);
        if (pre != null) minValue = Math.min(minValue, cur.val - pre.val);
        pre = cur; // 记录前一个节点
        traverse(cur.right);
    }
}