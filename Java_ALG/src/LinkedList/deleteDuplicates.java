package LinkedList;

/**
 * @program: alghorithm
 * @description: 删除有序数组中的重复项
 * @author: wangzijin
 * @create: 2024-03-19 16:29
 **/
// https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
// 思路和 src/Array/removeDuplicates.java 一样
public class deleteDuplicates {
    public ListNode method(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                // nums[slow] = nums[fast] -> 替换成用指针做
                slow.next = fast;
                slow = slow.next;
                // slow.val = fast.val;
            }
            fast = fast.next;
        }
        // ! 一定要断开 slow后面的节点, 不然就会返回重复元素
        slow.next = null;
        return head;
    }
}
