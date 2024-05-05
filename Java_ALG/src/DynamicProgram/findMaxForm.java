package DynamicProgram;


/**
 * @program: alghorithm
 * @description: 一和零
 * @author: wangzijin
 * @create: 2024-05-05 13:44
 **/
// https://leetcode.cn/problems/ones-and-zeroes/
public class findMaxForm {
    public int method(String[] strs, int m, int n) {
        // 1.确定dp数组的含义: dp[i][j]: 装满i个0, j个1的容量的背包最多装了dp[i][j]个物品
        int[][] dp = new int[m + 1][n + 1]; // m个0，n个1
        // 2.确定递推公式: dp[i][j] = max(dp[i - x][j - y] + 1, dp[i][j]);
        // 3.初始化dp数组, 全部初始化为0
        // 4.确定遍历顺序：先遍历物品，再遍历背包容量
        for (String str : strs) { // 遍历物品
            int x = 0, y = 0; // x: 0的个数, y: 1的个数
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                if (aChar == '0') x++;
                else y++;
            }
            for (int i = m; i >= x; i--) { // 遍历背包容量
                for (int j = n; j >= y; j--) {
                    dp[i][j] = Math.max(dp[i - x][j - y] + 1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}