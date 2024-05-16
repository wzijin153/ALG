package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 两个字符串的删除操作
 * @author: wangzijin
 * @create: 2024-05-16 15:52
 **/
// https://leetcode.cn/problems/delete-operation-for-two-strings/
public class minDistance {
    public int method(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        // 1.确定dp数组的含义: dp[i][j]: 以i-1结尾的word1和以j-1结尾的word2，这两个字符串相同的最少操作为dp[i][j]
        int[][] dp = new int[length1 + 1][length2 + 1];
        /**
         * 2.确定递推公式
         * if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
         * else dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
         */
        // 3.初始化dp数组
        for (int i = 0; i <= length1; i++) dp[i][0] = i;
        for (int j = 0; j <= length2; j++) dp[0][j] = j;
        // 4.确定遍历顺序
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 2);
            }
        }
        return dp[length1][length2];
    }
}