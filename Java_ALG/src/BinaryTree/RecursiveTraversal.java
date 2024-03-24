package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 递归遍历
 * @author: wangzijin
 * @create: 2024-03-24 15:54
 **/
/*
    递归三要素:
    1.确定递归函数的参数和返回值
    2.确定终止条件
    3.确定单层递归的逻辑
 */
public class RecursiveTraversal {
    // 前序遍历, https://leetcode.cn/problems/binary-tree-preorder-traversal/
    public List<Integer> method(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> result) {
        // 终止条件
        if (root == null) return;
        // TODO 遍历顺序: 根节点 -> 左节点 -> 右节点
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    // 中序遍历, https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        // TODO 遍历顺序: 左节点 -> 根节点 -> 右节点
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }

    // 后序遍历, https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        // TODO 遍历顺序: 左节点 -> 右节点 -> 根节点
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}

