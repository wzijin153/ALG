package Array;

/**
 * @program: alghorithm
 * @description: 反转字符串
 * @author: wangzijin
 * @create: 2024-03-20 09:19
 **/
// https://leetcode.cn/problems/reverse-string/description/
public class reverseString {
    public void method(char[] s) {
        if (s == null || s.length == 0 || s.length == 1) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
