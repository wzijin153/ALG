package LinkedList;

/**
 * @program: alghorithm
 * @description: 反转链表
 * @author: wangzijin
 * @create: 2024-02-28 19:04
 **/

// https://leetcode.cn/problems/reverse-linked-list/
class reverseList {
    public ListNode method(LinkedList list) {
        ListNode cur = list.head;
        ListNode pre = null;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归反转: https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/
    // 1.递归反转整个链表
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 递归反转链表前 N 个节点
    ListNode successor = null;// successor: 后驱节点, 这个不能放在reverseN()方法里, 不然每次调用都会重新声明
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n -1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // 递归反转链表的一部分
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n -1);
        return head;
    }
}