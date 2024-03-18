package LinkedList;

import java.util.ArrayList;

/**
 * @program: alghorithm
 * @description: 回文链表
 * @author: wangzijin
 * @create: 2024-03-17 15:49
 **/
// https://leetcode.cn/problems/palindrome-linked-list/?envType=study-plan-v2&envId=top-100-liked
/*
    1.将值复制到数组中后用双指针法
    2.遍历链表将值复制到数组列表中
    3.使用左右双指针判断数组是否回文
 */
public class isPalindrome {
    public boolean method(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        // 将链表的值复制到数组中
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // 如果list.get(left)的值不等于list.get(right), 则不是回文列表 -> 不是回文链表
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}