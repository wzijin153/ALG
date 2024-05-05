package Array;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 有序数组的平方
 * @author: wangzijin
 * @create: 2024-02-19 20:17
 **/
// https://leetcode.cn/problems/squares-of-a-sorted-array/description/
class SortedSquares {
    public int[] method(int[] nums) {
        /**
         * 用双指针，不要使用Arrays.sort(nums)
         * 暴力排序时间复杂度：O(n + nlogN)
         * 双指针时间复杂度：O(n)
         */
        int length = nums.length;
        int[] result = new int[length];
        int left = 0, right = length - 1;
        int index = length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        SortedSquares test = new SortedSquares();
        int[] res = test.method(nums);
        System.out.println(Arrays.toString(res));
    }
}