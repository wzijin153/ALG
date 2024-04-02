package BinaryTree;

/**
 * @program: alghorithm
 * @description: 二叉搜索树中的搜索
 * @author: wangzijin
 * @create: 2024-04-02 21:31
 **/
// https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
/*
    二叉搜索树是有序树！
    1.若左子树不空，则左子树上所有结点的值均小于根结点的值
    2.若右子树不空，则右子树上所有结点的值均大于根结点的值
 */
public class searchBST {
    public TreeNode method(TreeNode root, int val) {
        while (root != null) {
            if (root.val < val) root = root.left;
            else if (root.val > val) root = root.right;
            else return root;
        }
        return null;
    }

    // 递归, 不用考虑遍历顺序
    TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode res;
        if (root.val > val) res = search(root.left, val);
        else res = search(root.right, val);
        return res;
    }
}