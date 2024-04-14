package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 电话号码的字母组合
 * @author: wangzijin
 * @create: 2024-04-11 21:20
 **/
// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
public class letterCombinations {
    String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder str = new StringBuilder(); // 单个结果
    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        letterCombinations test = new letterCombinations();
        String digits = "23";
        test.method(digits);
    }

    void backtracking(String digits, int index) { // index表示当前遍历到digits的第几个字符
        // 终止条件
        if (index == digits.length()) {
            result.add(str.toString()); // 收获结果
            return;
        }
        // 单层逻辑
        int digit = digits.charAt(index) - '0'; // 将字母"123"转换为int类型
        String letter = letterMap[digit];
        for (int i = 0; i < letter.length(); i++) {
            str.append(letter.charAt(i));
            backtracking(digits, index + 1); // index表示当前遍历到digits的第几个字符, 然后进行拼接
            str.deleteCharAt(str.length() - 1);// 回溯: 删除str的最后一个字符, 然后向上回溯
        }

    }

    public List<String> method(String digits) {
        if (digits.isEmpty()) return result; // 用isEmpty去判断可以包含digits==null || digits.length()==0两种情况
        backtracking(digits, 0);
        return result;
    }
}