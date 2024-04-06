package BinaryTree;

/**
 * @program: alghorithm
 * @description: 二叉搜索树的最近公共祖先
 * @author: wangzijin
 * @create: 2024-04-06 14:51
 **/
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class lowestCommonAncestorAVL {
    public TreeNode method(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root, p, q);
    }

    // 利用二叉搜索树的特性(有序树)
    TreeNode traverse(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) return cur;
        // 如果 cur.val 大于 p.val 且 大于 q.val，那么就应该向左遍历
        if (cur.val > p.val && cur.val > q.val) {
            TreeNode left = traverse(cur.left, p, q);
            if (left != null) return left;
        }
        // 如果 cur->val 小于 p->val 且 小于 q->val，那么就应该向右遍历
        if (cur.val < p.val && cur.val < q.val) {
            TreeNode right = traverse(cur.right, p, q);
            if (right != null) return right;
        }
        // cur.val 在[p.val, q.val]的中间 -> cur就是p 和 q的公共祖先
        return cur;
    }
}