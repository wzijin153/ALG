package BinaryTree;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 从中序与后序遍历构造二叉树
 * @author: wangzijin
 * @create: 2024-03-31 20:15
 **/
// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class buildTree1 {
    public static void main(String[] args) {
        buildTree1 test = new buildTree1();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        test.method(inorder, postorder);
    }

    public TreeNode method(int[] inorder, int[] postorder) {
        return traverse(inorder, postorder);
    }

    TreeNode traverse(int[] inorder, int[] postorder) {
        // 1.终止条件: 后序数组长度为0, 空节点
        if (postorder.length == 0) return null;
        // 2.后序数组里最后一个元素为中间节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        if (postorder.length == 1) return root;
        // 3.寻找中序数组中上述中间节点的下标
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }
        // 4.切割中序数组, 得到左中序数组和右中序数组
        // 左闭右开区间：[0, index)
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        // [index + 1, end), 需要 + 1再切割, 因为index处的元素是中间节点
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        // 5.切割后序数组, 得到左后序数组和右后序数组
        // postorder 舍弃末尾元素
        int[] post = Arrays.copyOf(postorder, postorder.length - 1);
        // 使用左中序数组大小作为切割点[0, leftInorder.length)
        int[] leftPostorder = Arrays.copyOfRange(post, 0, leftInorder.length);
        // [leftInorder.length, end)
        int[] rightPostorder = Arrays.copyOfRange(post, leftInorder.length, post.length);
        // 6.递归处理左区间和右区间
        root.left = traverse(leftInorder, leftPostorder);// 左中序数组, 左后序数组
        root.right = traverse(rightInorder, rightPostorder);// 右中序数组, 右后序数组
        return root;
    }
}