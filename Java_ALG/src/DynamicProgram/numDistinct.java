package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 不同的子序列
 * @author: wangzijin
 * @create: 2024-05-16 15:19
 **/
// https://leetcode.cn/problems/distinct-subsequences/
public class numDistinct {
    public int method(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        // 1.确定dp数组的含义: dp[i][j]: 以i-1结尾的s中有以j-1结尾的t的个数为dp[i][j]
        int[][] dp = new int[length1 + 1][length2 + 1];
        /**
         * 2.确定递推公式
         * if (s[i - 1] == t[j - 1]) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
         * else dp[i][j] = dp[i - 1][j];
         */
        // 3.初始化dp数组
        for (int i = 0; i < length1; i++) dp[i][0] = 1; // 初始化第1列
        // 4.确定遍历顺序
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[length1][length2];
    }
}