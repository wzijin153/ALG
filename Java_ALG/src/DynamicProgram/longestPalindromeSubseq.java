package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 最长回文子序列
 * @author: wangzijin
 * @create: 2024-05-17 21:32
 **/
// https://leetcode.cn/problems/longest-palindromic-subsequence/
public class longestPalindromeSubseq {
    public int method(String s) {
        int length = s.length();
        int result = 0;
        // 1.确定dp数组的含义: dp[i][j]: [i, j]的回文子序列的长度为dp[i][j]
        int[][] dp = new int[length + 1][length + 1];
        /**
         * 2.确定递推公式
         * if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
         * else dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
         */
        // 3.初始化dp数组
        for (int i = 0; i < length; i++) dp[i][i] = 1;
        // 4.确定遍历顺序
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][length - 1];
    }
}