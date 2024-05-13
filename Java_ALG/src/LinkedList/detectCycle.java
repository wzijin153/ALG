package LinkedList;

/**
 * @program: alghorithm
 * @description: 环形链表 II
 * @author: wangzijin
 * @create: 2024-03-03 11:19
 **/
// https://leetcode.cn/problems/linked-list-cycle-ii/description/
class detectCycle {
    public ListNode method(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {// 当 fast.next 为 null 时, fast.next.next 会有空指针异常
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { // fast和slow相遇->有环，但不代表相遇的地方是环的起点!!!
                // 快慢指针相遇，此时从head和相遇点，同时查找直至相遇
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}