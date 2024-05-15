package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 最长公共子序列
 * @author: wangzijin
 * @create: 2024-05-15 13:29
 **/
// https://leetcode.cn/problems/longest-common-subsequence/
public class longestCommonSubsequence {
    public int method(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        // 1.确定dp数组的含义: dp[i][j]: 以[0, i-1]结尾的text1和以[0, j-1]结尾的text2，这两个子数组的最长公共子序列的长度为dp[i][j]
        int[][] dp = new int[length1 + 1][length2 + 1];
        /**
         * 2.确定递推公式
         * if (text1[i - 1] == text2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
         * else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
         */
        // 3.初始化dp数组, 全部初始化为0
        // 4.确定遍历顺序
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[length1][length2];
    }
}