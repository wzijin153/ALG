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
        int length1 = haystack.length();
        int length2 = needle.length();
        if (length2 > length1) return -1;
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < length1; i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i)) j++;
            if (j == length2) return i - length2 + 1;
        }
        return -1;
    }

    //KMP 算法
    int[] getNext(String s) {
        int length = s.length();
        // 1.初始化next数组
        int[] next = new int[length];
        int j = 0;// j -> 前缀末尾
        next[0] = 0;
        for (int i = 1; i < length; i++) {// i -> 后缀末尾, 这里 i 要从 1 开始!!!, 因为 i 总是在 j 的前面
            // 2.处理前后缀不相同的情况, 此时j要持续回退到next数组里前一位元素所代表的下标
            while (j > 0 && s.charAt(j) != s.charAt(i)) j = next[j - 1];
            // 3.处理前后缀相同的情况
            if (s.charAt(j) == s.charAt(i)) j++;
            // 4.更新next数组
            next[i] = j;
        }
        return next;
    }
}