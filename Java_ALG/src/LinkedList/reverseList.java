package LinkedList;

/**
 * @program: alghorithm
 * @description: 反转链表
 * @author: wangzijin
 * @create: 2024-02-28 19:04
 **/

// 反转一个单链表 https://leetcode.cn/problems/reverse-linked-list/
// 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
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
}