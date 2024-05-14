package DynamicProgram;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 最长递增子序列
 * @author: wangzijin
 * @create: 2024-05-14 14:07
 **/
// https://leetcode.cn/problems/longest-increasing-subsequence/description/
public class lengthOfLIS {
    public int method(int[] nums) {
        int length = nums.length;
        if (length == 1) return 1;
        int result = 0;
        // 1.确定dp数组的含义: dp[i]: 截至且包括下标i, 最长递增子序列的长度为dp[i]
        int[] dp = new int[length + 1]; // m个0，n个1
        // 2.确定递推公式: dp[i][0] =
        // 3.初始化dp数组
        Arrays.fill(dp, 1);
        // 4.确定遍历顺序
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) { // 遍历j之前的每一个元素, 取子序列长度作比较
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}