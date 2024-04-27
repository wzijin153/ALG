package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 不同路径
 * @author: wangzijin
 * @create: 2024-04-27 15:13
 **/
// https://leetcode.cn/problems/unique-paths/description/
public class uniquePaths {
    public int method(int m, int n) {
        // 1.确定dp数组的含义: dp[i][j]: 从(0, 0)出发，到达(i, j)的不同路径一共有dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // 2.确定递推公式: dp[i][j] = dp[i][j - 1] + dp[i - 1][j], 分别代表向右的不同和向下的不同路径
        // 3.初始化dp数组
        for (int i = 0; i < m; i++) dp[i][0] = 1; // 初始化第1列, 向下
        for (int j = 0; j < n; j++) dp[0][j] = 1; // 初始化第1行, 向you
        // 4.确定遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}