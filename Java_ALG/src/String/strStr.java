package String;

/**
 * @program: alghorithm
 * @description: 找出字符串中第一个匹配项的下标
 * @author: wangzijin
 * @create: 2024-03-20 23:21
 **/

public class strStr {
    public int method(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int nLen = needle.length();
        for (int i = 0; i <= haystack.length() - nLen; i++) {
            String substring = haystack.substring(i, i + nLen);
            if (substring.equals(needle)) return i;
        }
        return -1;
    }
}