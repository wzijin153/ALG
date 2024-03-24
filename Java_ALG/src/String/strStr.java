package String;

/**
 * @program: alghorithm
 * @description: 找出字符串中第一个匹配项的下标
 * @author: wangzijin
 * @create: 2024-03-20 23:21
 **/
//https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class strStr {
    public int method(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int nLen = needle.length();
//        for (int i = 0; i <= haystack.length() - nLen; i++) {
//            String substring = haystack.substring(i, i + nLen);
//            if (substring.equals(needle)) return i;
//        }
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) j++;
            if (j == nLen) return i - nLen + 1;
        }
        return -1;
    }

    //KMP 算法
    int[] getNext(String s) {
        int[] next = new int[s.length()];
        int j = 0;// j -> 前缀末尾
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {// i -> 后缀末尾, 这里 i 要从 1 开始!!!, 因为 i 总是在 j 的前面
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) j++;
            next[i] = j;
        }
        return next;
    }
}