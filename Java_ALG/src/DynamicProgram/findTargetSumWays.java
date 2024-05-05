package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 目标和
 * @author: wangzijin
 * @create: 2024-05-04 15:14
 **/

public class findTargetSumWays {
    public int method(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (Math.abs(target) > sum) return 0; // 如果target的绝对值大于sum，那么是没有方案的
        if ((target + sum) % 2 != 0) return 0; // 余数不为0，也没有方案
        /**
         * 这里把nums分为左部分(+号)和右部分(-号)
         * left + right = sum
         * left + right = target
         * left = (sum + target) / 2
         */
        int length = nums.length;
        // 1.确定dp数组的含义: dp[j]: 装满容量为j的背包一共有dp[j]种方法

        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        // 2.确定递推公式: dp[j] += dp[j - nums[i]]
        /**
         * 在求装满背包有几种方法的情况下(背包类组合问题)，递推公式一般为: dp[j] += dp[j - nums[i]]
         */
        // 3.初始化dp数组
        dp[0] = 1;
        // 4.确定遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }
}