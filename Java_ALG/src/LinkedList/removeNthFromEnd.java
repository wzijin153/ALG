package LinkedList;

/**
 * @program: alghorithm
 * @description: 删除链表的倒数第N个节点
 * @author: wangzijin
 * @create: 2024-03-01 19:01
 **/

class removeNthFromEnd {
    public ListNode method(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}