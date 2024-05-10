package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 打家劫舍
 * @author: wangzijin
 * @create: 2024-05-08 13:39
 **/
// https://leetcode.cn/problems/house-robber/description/
public class rob {
    public int method(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        // 1.确定dp数组的含义: dp[i]: 考虑下标i, 所能偷的最大金额为dp[i]
        int[] dp = new int[length];
        /**
         * 偷i: dp[i - 2] + nums[i]
         * 不偷i: dp[i - 1]
         * */
        // 2.确定递推公式: dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
        // 3.初始化dp数组
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 4.确定遍历顺序
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1]; //
    }
}