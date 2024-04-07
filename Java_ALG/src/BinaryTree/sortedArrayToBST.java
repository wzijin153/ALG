package BinaryTree;

/**
 * @program: alghorithm
 * @description: 将有序数组转换为二叉搜索树
 * @author: wangzijin
 * @create: 2024-04-07 19:29
 **/
// https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
public class sortedArrayToBST {
    public static void main(String[] args) {
        sortedArrayToBST test = new sortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        test.construct(nums, 0, nums.length - 1);
    }

    public TreeNode method(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    TreeNode construct(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = nums[left + right / 2];
        TreeNode root = new TreeNode(mid);
        root.left = construct(nums, left, mid - 1);
        root.right = construct(nums, mid + 1, right);
        return root;
    }
}