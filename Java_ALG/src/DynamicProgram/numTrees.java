package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 不同的二叉搜索树
 * @author: wangzijin
 * @create: 2024-05-03 14:07
 **/
// https://leetcode.cn/problems/unique-binary-search-trees/
public class numTrees {
    public int method(int n) {
        // 1.确定dp数组的含义: dp[i]:  1到i为节点组成的二叉搜索树的个数为dp[i]
        int[] dp = new int[n + 1];
        // 2.确定递推公式: dp[i] += dp[j - 1] * dp[i - j]
        // 3.初始化dp数组, dp[0] dp[1] 不应该初始化，也就是没有意义的数值
        dp[0] = 1; // 空节点也是一棵二叉树，也是一棵二叉搜索树
        // 4.确定遍历顺序
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}