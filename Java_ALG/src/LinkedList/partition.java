package LinkedList;

/**
 * @program: alghorithm
 * @description: 分隔链表
 * @author: wangzijin
 * @create: 2024-03-14 16:08
 **/

class partition {
    public ListNode method(ListNode head, int x) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                cur.next = node;
            }
        }

        return dummyHead.next;
    }
}
