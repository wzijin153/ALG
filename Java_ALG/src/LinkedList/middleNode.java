package LinkedList;

/**
 * @program: alghorithm
 * @description: 单链表的中点
 * @author: wangzijin
 * @create: 2024-03-17 13:12
 **/

/*
    1.定义两个指针 slow 和 fast 分别指向链表头结点 head
    2.每当慢指针 slow 前进1步，快指针 fast 就前进2步，这样，当 fast 走到链表末尾时，slow 就指向了链表中点
 */
public class middleNode {
    public ListNode method(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}