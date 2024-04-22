package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 划分字母区间
 * @author: wangzijin
 * @create: 2024-04-22 22:09
 **/
// https://leetcode.cn/problems/partition-labels/description/
public class partitionLabels {
    public List<Integer> method(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i; // 记录每个字母出现的最远位置
        }
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']); // 找到字符出现的最远边界
            if (i == right) result.add(right - left + 1); // 到达最远边界就可以收获结果了
            left = i + 1; // 将下一个左边界更新为下一个下标
        }
        return result;
    }
}