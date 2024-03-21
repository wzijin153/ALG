package HashTable;

/**
 * @program: alghorithm
 * @description: 赎金信
 * @author: wangzijin
 * @create: 2024-03-21 21:55
 **/

public class canConstruct {
    public boolean method(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] ints = new int[26];
        for (char c : magazine.toCharArray()) {
            ints[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            ints[c - 'a']--;
        }
        for (int anInt : ints) {
            if (anInt < 0) return false;
        }
        return true;
    }
}