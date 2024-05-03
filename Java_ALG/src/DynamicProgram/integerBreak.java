package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 整数拆分
 * @author: wangzijin
 * @create: 2024-05-03 13:42
 **/
// https://leetcode.cn/problems/integer-break/description/
public class integerBreak {
    public int method(int n) {
        // 1.确定dp数组的含义: dp[i]: 分拆数字i, 得到的最大的乘积为dp[i]
        int[] dp = new int[n + 1];
        // 2.确定递推公式: dp[i] = max(j * dp[i - j], j * (i - j), dp[i])
        // 3.初始化dp数组, dp[0] dp[1] 不应该初始化，也就是没有意义的数值
        dp[2] = 1;
        // 4.确定遍历顺序
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}