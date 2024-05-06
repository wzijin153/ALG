package DynamicProgram;

import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 完全平方数
 * @author: wangzijin
 * @create: 2024-05-06 14:20
 **/
// https://leetcode.cn/problems/perfect-squares/description/
public class numSquares {
    public int method(int n) {
        // 1.确定dp数组的含义: dp[j]: 和为j的完全平方数的最少数量为dp[j]
        // 2.确定递推公式: dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
        int[] dp = new int[n + 1];
        // 3.初始化dp数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 4.确定遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
