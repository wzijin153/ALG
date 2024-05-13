package HashTable;


/**
 * @program: alghorithm
 * @description: 有效的字母异位词
 * @author: wangzijin
 * @create: 2024-03-04 22:08
 **/
// https://leetcode.cn/problems/valid-anagram/
class isAnagram {
    public boolean method(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
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
