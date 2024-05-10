package LinkedList;

/**
 * @program: alghorithm
 * @description: 两两交换链表中的节点
 * @author: wangzijin
 * @create: 2024-02-28 20:21
 **/

// https://leetcode.cn/problems/swap-nodes-in-pairs/description/
class swapPairs {
    public ListNode method(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        ListNode temp;
        ListNode temp1;
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next;
            temp1 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = temp1;
            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}