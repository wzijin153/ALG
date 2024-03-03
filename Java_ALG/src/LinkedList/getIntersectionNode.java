package LinkedList;

/**
 * @program: alghorithm
 * @description: 链表相交
 * @author: wangzijin
 * @create: 2024-03-01 19:53
 **/

class getIntersectionNode {
    public ListNode method(ListNode headA, ListNode headB) {
        ListNode dummyHeadA = new ListNode(0, headA);
        ListNode dummyHeadB = new ListNode(0, headB);
        ListNode curA = dummyHeadA.next;
        ListNode curB = dummyHeadB.next;
        int sizeA = 0;
        int sizeB = 0;
        while (curA != null) {
            curA = curA.next;
            sizeA++;
        }
        while (curB != null) {
            curB = curB.next;
            sizeB++;
        }
        curA = dummyHeadA;
        curB = dummyHeadB;
        if (sizeA < sizeB) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                curB = curB.next;
            }
        }
        if (sizeB < sizeA) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                curA = curA.next;
            }
        }
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}