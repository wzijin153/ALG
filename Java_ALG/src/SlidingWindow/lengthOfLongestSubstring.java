package SlidingWindow;

import java.util.HashSet;

/**
 * @program: alghorithm
 * @description: 无重复字符的最长子串
 * @author: wangzijin
 * @create: 2024-03-11 10:49
 **/

// 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度 https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
// 1.用HashSet来存放已经遍历过的字符
// 2.滑动窗口也需要指定left和right两个指针, left和right都向右移动(双指针法里right向左移动)
// 3.遍历s, 用left和right遍历
// 4.遇到set里没有的元素时add, right右移, 然后计算maxLength
// 5.遇到set里有的元素时remove

public class lengthOfLongestSubstring {
    public int method(String s) {
        // 算法开头都要考虑为空的情况
        if (s == null || s.isEmpty()) {
            return 0;
        }
        HashSet<Character> charSet = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            if (!charSet.contains(s.charAt(right))) {
                // 当前字符不在窗口中，右指针向右移动
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, charSet.size());
                right++;
            }else {
                // 当前字符在窗口中，左指针向右移动
                charSet.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstring test = new lengthOfLongestSubstring();
        test.method(s);
    }
}
