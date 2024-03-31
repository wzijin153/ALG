package BinaryTree;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 从前序与中序遍历构造二叉树
 * @author: wangzijin
 * @create: 2024-03-31 21:32
 **/
// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class buildTree2 {
    public TreeNode method(int[] preorder, int[] inorder) {
        return traverse(preorder, inorder);
    }

    TreeNode traverse(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        if (preorder.length == 1) return root;
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }
        // 切割中序数组
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        // 去除前序数组第一个元素
        int[] pre = Arrays.copyOfRange(preorder, 1, preorder.length);
        // 切割前序数组
        int[] leftPreorder = Arrays.copyOfRange(pre, 0, leftInorder.length);
        int[] rightPreorder = Arrays.copyOfRange(pre, leftInorder.length, pre.length);
        root.left = traverse(leftPreorder, leftInorder);
        root.right = traverse(rightPreorder, rightInorder);
        return root;
    }
}