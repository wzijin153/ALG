package BinaryTree;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 最大二叉树
 * @author: wangzijin
 * @create: 2024-03-31 21:43
 **/
// https://leetcode.cn/problems/maximum-binary-tree/description/
public class constructMaximumBinaryTree {
    public TreeNode method(int[] nums) {
        return traverse((nums));
    }

    TreeNode traverse(int[] nums) {
        TreeNode node = new TreeNode();
        // 终止条件: 要保证nums里至少有一个元素
        if (nums.length == 1) {
            node.val = nums[0];
            return node;
        }
        int index = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        node.val = maxValue;
        // 构造左子树
        if (index > 0) {// 保证左区间至少有一个数值
            int[] leftNums = Arrays.copyOfRange(nums, 0, index);
            node.left = traverse(leftNums);
        }
        // 构造右子树
        if (index < nums.length - 1) {// 确保右区间至少有一个数值
            int[] rightNums = Arrays.copyOfRange(nums, index + 1, nums.length);
            node.right = traverse(rightNums);
        }
        return node;
    }
}