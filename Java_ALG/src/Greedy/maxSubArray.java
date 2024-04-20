package Greedy;

/**
 * @program: alghorithm
 * @description: 最大子序和
 * @author: wangzijin
 * @create: 2024-04-19 17:59
 **/
// https://leetcode.cn/problems/maximum-subarray/description/
public class maxSubArray {
    public int method(int[] nums) {
        if (nums.length == 1) return nums[0];
        int result = Integer.MIN_VALUE;
        int sum = 0; // 记录数组的连续和
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > result) result = sum;
            if (sum < 0) sum = 0; // 以下一个元素开始重新计数
        }
        return result;
    }
}