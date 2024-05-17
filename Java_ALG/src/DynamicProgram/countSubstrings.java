package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 回文子串
 * @author: wangzijin
 * @create: 2024-05-17 21:11
 **/
// https://leetcode.cn/problems/palindromic-substrings/description/
public class countSubstrings {
    public int method(String s) {
        int length = s.length();
        int result = 0;
        // 1.确定dp数组的含义: dp[i][j]: [i, j]的子串是否是回文的
        boolean[][] dp = new boolean[length + 1][length + 1];
        /**
         * 2.确定递推公式
         * if (s.charAt(i) == s.charAt(j)) {
         *     if (j - i <= 1) {
         *         dp[i][j] = true;
         *         result++;
         *     } else if (dp[i + 1][j - 1] == true) {
         *         dp[i][j] = true;
         *         result++;
         *     }
         * }
         */
        // 3.初始化dp数组, 全部初始化为false
        // 4.确定遍历顺序
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        result++;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}