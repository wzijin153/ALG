package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 买卖股票的最佳时机含手续费
 * @author: wangzijin
 * @create: 2024-05-13 15:45
 **/

public class maxProfitWithCharge {
    public int method(int[] prices, int fee) {
        int length = prices.length;
        if (length == 1) return 0;
        // 1.确定dp数组的含义: dp[i][0]: 持有股票的最大利润为dp[i], dp[i][1]: 不持有股票的最大利润为dp[i]
        int[][] dp = new int[length][2]; // m个0，n个1
        // 2.确定递推公式: dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i]), dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
        // 3.初始化dp数组
        dp[0][0] = -prices[0] - fee; // 买入时支付手续费
        dp[0][1] = 0;
        // 4.确定遍历顺序
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}