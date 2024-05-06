package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 零钱兑换
 * @author: wangzijin
 * @create: 2024-05-06 13:51
 **/
// https://leetcode.cn/problems/coin-change/description/
public class coinChange {
    public int method(int[] coins, int amount) {
        // 1.确定dp数组的含义: dp[i]: 装满容量为i的背包, 需要的最少物品为dp[i]
        int[] dp = new int[amount + 1];
        // 2.确定递推公式: dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
        // 3.初始化dp数组
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE; // 这里初始成最大值是因为递推公式里是取最小值
        // 4.确定遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                if (dp[j - coins[i]] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        for (int i : dp) System.out.print(i + " ");
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}