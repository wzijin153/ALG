package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 买卖股票的最佳时机III
 * @author: wangzijin
 * @create: 2024-05-10 14:30
 **/
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
public class maxProfit3 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) return 0;
        /**
         * 1.确定dp数组的含义
         * dp[i][0]: 不操作
         * dp[i][1]: 第一次持有
         * dp[i][2]: 第一次不持有
         * dp[i][3]: 第二次持有
         * dp[i][4]: 第二次不持有
         */
        int[][] dp = new int[length][5]; // m个0，n个1
        /**
         * 2.确定递推公式
         * dp[i][0] = dp[i - 1][0]
         * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
         * dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
         * dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
         * dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
         */
        // 3.初始化dp数组
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        // 4.确定遍历顺序
        for (int i = 1; i < length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[length - 1][4];
    }
}