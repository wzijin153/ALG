package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 买卖股票的最佳时机
 * @author: wangzijin
 * @create: 2024-05-10 13:36
 **/

public class maxProfit {
    public int method(int[] prices) {
        int length = prices.length;
        if (length == 1) return 0;
        // 1.确定dp数组的含义: dp[i][0]: 持有股票的最大利润为dp[i], dp[i][1]: 不持有股票的最大利润为dp[i]
        int[][] dp = new int[length][2]; // m个0，n个1
        // 2.确定递推公式: dp[i][0] = max(dp[i - 1][0], -prices[i]), dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
        // 3.初始化dp数组
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        // 4.确定遍历顺序
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]); // 持有股票的最大利润
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]); // 不持有股票的最大利润
        }
        return Math.max(dp[length - 1][0], dp[length - 1][1]);
    }
}