package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 使用最小花费爬楼梯
 * @author: wangzijin
 * @create: 2024-04-27 14:38
 **/
// https://leetcode.cn/problems/min-cost-climbing-stairs/description/
public class minCostClimbingStairs {
    public int method(int[] cost) {
        int n = cost.length;
        // 1.确定dp数组的含义: 爬到第i阶位置所需的最小花费为dp[i]
        int[] dp = new int[n + 1];
        // 2.确定递推公式: dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]), 因为一次可以跳1步或者2步, 要取最小花费
        // 3.初始化dp数组
        dp[0] = 0;
        dp[1] = 0; // 到达开头两个台阶不需要花费
        // 4.确定遍历顺序
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}