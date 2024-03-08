package HashTable;

import java.sql.Array;
import java.util.*;

/**
 * @program: alghorithm
 * @description: 最长连续序列
 * @author: wangzijin
 * @create: 2024-03-08 11:57
 **/

public class longestConsecutive {
    public int method(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
//        HashSet<Integer> result = new HashSet<>();
        HashMap<Integer, List<Integer>> result = new HashMap<>();
        HashSet<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }

        arrayList.sort(Comparator.naturalOrder());
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int lag = arrayList.get(i + 1);
            int now = arrayList.get(i);
            if (now - lag == 1) {
//                result.add(arrayList.get(i));
                result.computeIfAbsent(i + 1, k -> new ArrayList<>()).add(arrayList.get(i));
            }
        }
        return result.size() + 1;
    }

    public static void main(String[] args) {
        longestConsecutive test = new longestConsecutive();
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(test.method(nums));
    }
}
