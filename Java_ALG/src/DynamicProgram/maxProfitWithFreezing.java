package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 最佳买卖股票时机含冷冻期
 * @author: wangzijin
 * @create: 2024-05-13 14:58
 **/
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class maxProfitWithFreezing {
    public int method(int[] prices) {
        int length = prices.length;
        if (length == 1) return 0;
        /**
         * 1.确定dp数组的含义
         * dp[i][0]: 持有股票
         * dp[i][1]: 保持卖出股票
         * dp[i][2]: 卖出股票
         * dp[i][3]: 冷冻期
         */
        int[][] dp = new int[length][4]; // m个0，n个1
        /**
         * 2.确定递推公式
         * dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
         * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
         * dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i]);
         * dp[i][3] = dp[i - 1][2];
         */
        // 3.初始化dp数组
        dp[0][0] = -prices[0];
        // 4.确定遍历顺序
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + prices[i]);
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[length - 1][1], Math.max(dp[length - 1][2], dp[length - 1][3]));
    }
}