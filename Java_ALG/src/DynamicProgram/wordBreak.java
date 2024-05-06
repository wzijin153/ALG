package DynamicProgram;

import java.util.HashSet;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 单词拆分
 * @author: wangzijin
 * @create: 2024-05-06 15:17
 **/
// https://leetcode.cn/problems/word-break/description/
public class wordBreak {
    public boolean method(String s, List<String> wordDict) {
        // 1.确定dp数组的含义: dp[i]: 字符串长度为i，如果能被wordDict组成， 则dp[i]=true;
        int bagSize = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[bagSize + 1];
        // 2.确定递推公式: dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
        // 3.初始化dp数组
        dp[0] = true;
        // 4.确定遍历顺序：先遍历背包，再遍历物品(排列)
        /**
         * 组合类背包遍历顺序: 先遍历物品, 再遍历背包
         * 排列类背包遍历顺序: 先遍历背包, 再遍历物品
         */
        for (int i = 1; i <= bagSize; i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if (set.contains(s.substring(j, i - j)) && dp[j]) dp[i] = true;
            }
        }
        return dp[bagSize];
    }
}