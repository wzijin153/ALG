package Greedy;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: K次取反后最大化的数组和
 * @author: wangzijin
 * @create: 2024-04-20 13:29
 **/
// https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
public class largestSumAfterKNegations {
    public static void main(String[] args) {
        largestSumAfterKNegations test = new largestSumAfterKNegations();
        int[] nums = {4, 2, 3};
        int k = 1;
        System.out.println(test.method(nums, k));
    }

    public int method(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 1.第一次贪心: 先将数组中所有负数取反
            if (k > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 2.第二次贪心: 将剩下的k消耗掉, 数组中绝对值最小的元素一直取反
        Arrays.sort(nums);
        if (k % 2 == 1) {
            nums[0] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}