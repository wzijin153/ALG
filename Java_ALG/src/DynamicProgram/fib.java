package DynamicProgram;

/**
 * @program: alghorithm
 * @description: 斐波那契数
 * @author: wangzijin
 * @create: 2024-04-27 13:40
 **/
// https://leetcode.cn/problems/fibonacci-number/description/
public class fib {
    public static void main(String[] args) {
        fib test = new fib();
        int n = 4;
        test.method(n);
    }

    public int method(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}