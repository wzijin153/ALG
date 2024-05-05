package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 组合总和 Ⅳ
 * @author: wangzijin
 * @create: 2024-05-05 15:39
 **/
// https://leetcode.cn/problems/combination-sum-iv/
public class combinationSum4 {
    public int method(int[] nums, int target) {
        // 1.确定dp数组的含义: dp[i]: 容量为i的背包, 一共有dp[i]种排列
        int[] dp = new int[target + 1];
        // 2.确定递推公式: dp[j] += dp[j - nums[i]];
        // 3.初始化dp数组
        dp[0] = 1; // dp[0] = 1是递归公式的基础. 如果dp[0] = 0 的话，后面所有推导出来的值都是0
        // 4.确定遍历顺序：先遍历背包，再遍历物品
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) dp[j] = dp[j - nums[i]];
            }
        }
        for (int i : dp) System.out.print(i + " ");
        return dp[target];
    }
}