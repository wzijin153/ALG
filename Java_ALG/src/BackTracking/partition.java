package BackTracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
// https://leetcode.cn/problems/palindrome-partitioning/description/

/**
 * @program: alghorithm
 * @description: 分割回文串
 * @author: wangzijin
 * @create: 2024-04-14 14:49
 **/

public class partition {
    List<List<String>> result = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public static void main(String[] args) {
        partition test = new partition();
        String s = "aab";
        System.out.println(test.method(s));
    }

    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    void backtracking(String s, int startIndex) { // startIndex代表切割线
        // 终止条件
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(deque));
            return;
        }
        // 单层搜索逻辑
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
                backtracking(s, i + 1);
                deque.removeLast();
            }
        }
    }

    public List<List<String>> method(String s) {
        backtracking(s, 0);
        return result;
    }
}