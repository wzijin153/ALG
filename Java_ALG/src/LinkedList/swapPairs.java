package LinkedList;

/**
 * @program: alghorithm
 * @description: 两两交换链表中的节点
 * @author: wangzijin
 * @create: 2024-02-28 20:21
 **/

// 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表, 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
// https://leetcode.cn/problems/swap-nodes-in-pairs/description/
class swapPairs {
    public ListNode method(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
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