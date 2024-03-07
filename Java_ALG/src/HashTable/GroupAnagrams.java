package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: alghorithm
 * @description: 字母异位词分组
 * @author: wangzijin
 * @create: 2024-03-07 17:17
 **/

// 用 HashMap 求解
// 对于每个单词，将其排序后的形式作为键, 原始单词作为值，将具有相同键的单词归为一组
class GroupAnagrams {
    public List<List<String>> method(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();// 拆分 str, eat -> [e, a, t]
            Arrays.sort(charArray);
//          Arrays.sort(str.toCharArray()); 不起作用, 因为字符串是不可变的(immutable)对象, toCharArray()会返回一个新的字符串数组
            // 将排序后的字符数组组合为新的字符串
            String sortedStr = new String(charArray);// 组合 str
            // computeIfAbsent方法, https://www.runoob.com/java/java-hashmap-computeifabsent.html
            map.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams test = new GroupAnagrams();
        System.out.println(test.method(strs1));
    }
}
