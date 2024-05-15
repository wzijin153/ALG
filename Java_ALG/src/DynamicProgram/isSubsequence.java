package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 判断子序列
 * @author: wangzijin
 * @create: 2024-05-15 15:07
 **/
// https://leetcode.cn/problems/is-subsequence/, 思路和最长公共子序列一样
public class isSubsequence {
    public boolean method(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        // 1.确定dp数组的含义: dp[i][j]: 以i-1结尾的s和以j-1结尾的t，这两个子数组的最长公共子序列的长度为dp[i][j]
        int[][] dp = new int[length1 + 1][length2 + 1];
        /**
         * 2.确定递推公式
         * if (text1[i - 1] == text2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
         * else dp[i][j] = dp[i][j - 1];
         */
        // 3.初始化dp数组, 全部初始化为0
        // 4.确定遍历顺序
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[length1][length2] == length1; // s是t的子序列 -> dp[s.length()][t.length()] == s.length()
    }
}