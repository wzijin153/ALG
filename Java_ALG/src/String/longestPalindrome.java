package String;

/**
 * @program: alghorithm
 * @description: 寻找最长回文字串
 * @author: wangzijin
 * @create: 2024-03-20 12:38
 **/
//https://leetcode.cn/problems/longest-palindromic-substring/
/*
    1.左右指针从中心向两端扩展
    2.有两种情况: 1.回文串的长度为奇数，则它有一个中心字符; 2.回文串的长度为偶数，则可以认为它有两个中心字符
 */
public class longestPalindrome {
    public String method(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串, 奇数
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串, 偶数
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
