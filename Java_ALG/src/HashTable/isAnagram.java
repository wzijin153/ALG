package HashTable;


import java.util.Arrays;

/**
 * @program: alghorithm
 * @description: 有效的字母异位词
 * @author: wangzijin
 * @create: 2024-03-04 22:08
 **/

// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
// 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
// 示例 2: 输入: s = "rat", t = "car" 输出: false
class isAnagram {
    public boolean method(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
//        char[] sCharArray = s.toCharArray();
//        char[] tCharArray = t.toCharArray();
//        Arrays.sort(sCharArray);
//        Arrays.sort(tCharArray);
//        return Arrays.equals(sCharArray, tCharArray);
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        for (int j : hash) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}
