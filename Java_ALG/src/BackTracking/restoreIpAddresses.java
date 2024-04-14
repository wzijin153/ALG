package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 复原IP地址
 * @author: wangzijin
 * @create: 2024-04-14 15:37
 **/
// https://leetcode.cn/problems/restore-ip-addresses/description/
public class restoreIpAddresses {
    List<String> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        restoreIpAddresses test = new restoreIpAddresses();
        String s = "101023";
        System.out.println(test.method(s));
    }

    void backtracking(String s, int startIndex) {
        // 终止条件
        if (startIndex == s.length() && path.size() == 4) {
            String join = String.join(".", path);
            result.add(join);
            return;
        }
        // 单层搜索逻辑
        /*
         * 在for循环条件剪枝: 1.i - startIndex < 3: ip段的长度最大是3
         *                 2.当前分割字串的大小位于[0， 255]区间内
         * 在for循环体内剪枝: 长度大于1的ip网段不能以"0"开头
         */
        for (int i = startIndex; i < s.length() && i - startIndex < 3 && Integer.parseInt(s.substring(startIndex, i + 1)) >= 0 && Integer.parseInt(s.substring(startIndex, i + 1)) <= 255; i++) {
            String str = s.substring(startIndex, i + 1);
            if (str.length() > 1 && str.startsWith("0")) return;
            path.add(str);
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    public List<String> method(String s) {
        backtracking(s, 0);
        return result;
    }
}