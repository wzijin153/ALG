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
// https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
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
            /*
            1. 如果 sortedStr 已经存在于映射中，computeIfAbsent 返回与该键关联的现有 List<String>
            2. 如果 sortedStr 不存在，computeIfAbsent 创建一个新的 ArrayList<String>，将其与键 sortedStr 关联，并返回新创建的列表
            3. 在 computeIfAbsent 返回的值上调用 add(str)
             */
            map.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str); // 用排序后的字符作为key, 可以满足异位词的定义
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams test = new GroupAnagrams();
        System.out.println(test.method(strs1));
    }
}
