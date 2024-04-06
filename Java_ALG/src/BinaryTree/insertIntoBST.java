package BinaryTree;

/**
 * @program: alghorithm
 * @description: 二叉搜索树中的插入操作
 * @author: wangzijin
 * @create: 2024-04-06 15:40
 **/
// https://leetcode.cn/problems/insert-into-a-binary-search-tree/
public class insertIntoBST {
    public TreeNode method(TreeNode root, int val) {
        return traverse(root, val);
    }

    TreeNode traverse(TreeNode root, int val) {
        // 终止条件: 当前节点为空说明找到新节点插入的位置了
        if (root == null) return new TreeNode(val);
        // 寻找数值在叶子节点对应的位置
        if (root.val > val) root.left = traverse(root.left, val);
        else root.right = traverse(root.right, val);
        return root;
    }
}