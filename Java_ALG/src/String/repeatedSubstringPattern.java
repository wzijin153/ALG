package String;

/**
 * @program: alghorithm
 * @description: 重复的子字符串
 * @author: wangzijin
 * @create: 2024-03-22 23:04
 **/
// https://leetcode.cn/problems/repeated-substring-pattern/description/
public class repeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "aba";
        repeatedSubstringPattern test = new repeatedSubstringPattern();
        test.method(s);
    }

    public boolean method(String s) {
//        String str = s + s;
//        for (int i = 1; i < str.length() - s.length(); i++) {
//            String s1 = str.substring(i, i + s.length());
//            if (s1.equals(s)) return true;
//        }
        int[] next = getNext(s);
        // 长度 % (长度 - 最长前后缀) == 0
        return next[s.length() - 1] != 0 && s.length() % (s.length() - next[s.length() - 1]) == 0;
    }

    int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {// i 要从 1 开始!!!, 因为 i 总是在 j 的前面
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) j++;
            next[i] = j;
        }
        return next;
    }
}