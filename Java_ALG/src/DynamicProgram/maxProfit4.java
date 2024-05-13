package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 买卖股票的最佳时机IV
 * @author: wangzijin
 * @create: 2024-05-13 14:21
 **/
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
public class maxProfit4 {
    public int method(int k, int[] prices) {
        int length = prices.length;
        if (length == 1) return 0;
        int[][] dp = new int[length][2 * k + 1];
        // 3.初始化dp数组: 只需要初始化第0天下标为奇数次的操作
        for (int i = 1; i < 2 * k; i += 2) dp[0][i] = -prices[0];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < 2 * k; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[length - 1][2 * k];
    }
}