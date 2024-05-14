package DynamicProgram;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 最长连续递增序列
 * @author: wangzijin
 * @create: 2024-05-14 14:39
 **/
// https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
public class findLengthOfLCIS {
    public int method(int[] nums) {
        int length = nums.length;
        if (length == 1) return 1;
        int result = 0;
        // 1.确定dp数组的含义: dp[i]: 截至且包括下标i, 最长连续递增子序列的长度为dp[i]
        int[] dp = new int[length + 1]; // m个0，n个1
        // 2.确定递推公式: dp[i] = dp[i - 1] + 1 -> 要求连续子序列, 只要比较nums[i]与nums[i - 1]
        // 3.初始化dp数组
        Arrays.fill(dp, 1);
        // 4.确定遍历顺序
        for (int i = 1; i < length; i++) { // 一层for循环就行，比较nums[i] 和 nums[i - 1]
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
}