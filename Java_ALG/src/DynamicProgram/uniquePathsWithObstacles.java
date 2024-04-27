package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 不同路径 II
 * @author: wangzijin
 * @create: 2024-04-27 15:45
 **/

public class uniquePathsWithObstacles {
    public static void main(String[] args) {
        uniquePathsWithObstacles test = new uniquePathsWithObstacles();
        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        test.method(obstacleGrid);
    }

    public int method(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 1.确定dp数组的含义: dp[i][j]: 从(0, 0)出发，到达(i, j)的不同路径一共有dp[i][j]
        int[][] dp = new int[m][n];
        // 2.确定递推公式: dp[i][j] = dp[i][j - 1] + dp[i - 1][j], 分别代表向右的不同和向下的不同路径
        // 3.初始化dp数组, 这里初始化dp数组时, 要考虑该条路径上是否存在障碍物, 有障碍物就不初始化
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++)
            dp[i][0] = 1; // 一旦遇到obstacleGrid[i][0] == 1的情况就停止dp[i][0]的赋值1的操作
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;
        // 4.确定遍历顺序
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}