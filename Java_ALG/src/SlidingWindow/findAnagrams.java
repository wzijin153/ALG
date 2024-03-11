package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 找到字符串中所有字母异位词
 * @author: wangzijin
 * @create: 2024-03-11 15:04
 **/

// 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序 https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
// 1.创建一个哈希表 charCountMap，用于记录字符串 p 中每个字符的出现次数
// 2.使用两个指针 left 和 right 分别表示滑动窗口的左右边界。初始时，它们都指向字符串的起始位置
// 3.移动右指针 right，并更新 charCountMap 中对应字符的出现次数。
// 4.当发现当前字符在 charCountMap 中，表示匹配到了字符串 p 中的一个字符，此时将 matchCount 增加。
// 5.当 matchCount 等于 charCountMap 中字符的种类数时，说明当前窗口包含了字符串 p 的所有字符，可以进行比较
// 6.移动左指针 left，并更新 charCountMap 中对应字符的出现次数。
// 7.如果发现当前字符在 charCountMap 中，表示匹配到了字符串 p 中的一个字符，此时将 matchCount 减少
// 8.重复步骤 3-7，直到右指针 right 到达字符串的末尾。
// 9.返回结果列表，其中存储了满足条件的起始索引
public class findAnagrams {
    public List<Integer> method(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }
        HashMap<Character, Integer> charCountMap  = new HashMap<>();// 记录字符串 p 中每个字符的出现次数
        for (char c : p.toCharArray()) {
            // getOrDefault(): 获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值 https://www.runoob.com/java/java-hashmap-getordefault.html
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, matchCount = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (charCountMap.containsKey(rightChar)) {
                // - 1 是因为如果str1是str2的字母异位词, 则它们对应字符出现的次数相减为0
                charCountMap.put(rightChar, charCountMap.get(rightChar) - 1);
                // 字母异位词思想: HashTable/isAnagram.java
                if (charCountMap.get(rightChar) == 0) {// == 0 说明匹配上
                    matchCount++;
                }
            }
            // 当matchCount == charCountMap的size时, 可以开始比较, 限定比较条件
            while (matchCount == charCountMap.size()) {
                if (right - left == p.length() - 1) {// 限定滑动窗口[left, right]的长度为字符串p的长度
                    result.add(left);
                }
                char leftChar = s.charAt(left);
                if (charCountMap.containsKey(leftChar)) {
                    charCountMap.put(leftChar, charCountMap.get(leftChar) + 1);
                    // > 0说明不匹配, 参考上面 == 0的判断, 不匹配需要减matchCount
                    if (charCountMap.get(leftChar) > 0) {
                        matchCount--;
                    }
                }
                left++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams test = new findAnagrams();
        test.method(s, p);
    }
}
