package Greedy;

/**
 * @program: alghorithm
 * @description: 单调递增的数字
 * @author: wangzijin
 * @create: 2024-04-24 20:01
 **/

public class monotoneIncreasingDigits {
    public static void main(String[] args) {
        monotoneIncreasingDigits test = new monotoneIncreasingDigits();
        int n = 332;
        System.out.println(test.method(n));
    }

    public int method(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int flag = chars.length;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                flag = i;
            }
        }
        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}