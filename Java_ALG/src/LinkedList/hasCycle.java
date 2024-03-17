package LinkedList;

/**
 * @program: alghorithm
 * @description: 环形链表
 * @author: wangzijin
 * @create: 2024-03-17 14:54
 **/
// https://leetcode.cn/problems/linked-list-cycle/
/*
    1.每当慢指针 slow 前进1步，快指针 fast 就前进2步
    2.如果 fast 最终遇到空指针，说明链表中没有环
    3.如果 fast 最终和 slow 相遇，那肯定是 fast 超过了 slow 一圈，说明链表中含有环
 */
public class hasCycle {
    public boolean method(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}