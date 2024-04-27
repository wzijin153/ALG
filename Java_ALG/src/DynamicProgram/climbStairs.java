package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 爬楼梯
 * @author: wangzijin
 * @create: 2024-04-27 14:09
 **/
// https://leetcode.cn/problems/climbing-stairs/description/
public class climbStairs {
    public int method(int n) {
        if (n == 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}