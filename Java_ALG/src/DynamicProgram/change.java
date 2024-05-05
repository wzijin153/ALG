package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 零钱兑换II
 * @author: wangzijin
 * @create: 2024-05-05 15:14
 **/
// https://leetcode.cn/problems/coin-change-ii/description/
public class change {
    public static void main(String[] args) {
        change test = new change();
        int amount = 5;
        int[] coins = {1, 2, 5};
        test.method(amount, coins);
    }

    public int method(int amount, int[] coins) {
        // 1.确定dp数组的含义: dp[i]: 容量为i的背包, 一共有dp[i]种组合
        int[] dp = new int[amount + 1];
        // 2.确定递推公式: dp[j] += dp[j - coins[i]];
        // 3.初始化dp数组
        dp[0] = 1; // dp[0] = 1是递归公式的基础. 如果dp[0] = 0 的话，后面所有推导出来的值都是0
        // 4.确定遍历顺序：先遍历物品，再遍历背包容量
        /**
         * 组合类背包遍历顺序: 先遍历物品, 再遍历背包
         * 排列类背包遍历顺序: 先遍历背包, 再遍历物品
         * */
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        for (int i : dp) System.out.print(i + " ");
        return dp[amount];
    }
}