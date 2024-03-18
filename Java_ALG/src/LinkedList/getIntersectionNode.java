package LinkedList;

/**
 * @program: alghorithm
 * @description: 相交链表
 * @author: wangzijin
 * @create: 2024-03-01 19:53
 **/
// https://leetcode.cn/problems/intersection-of-two-linked-lists/
    /*
    1.不要用两个循环遍历链表得到链表长度!
    2.如果用两个指针 p1 和 p2 分别在两条链表上前进，并不能同时走到公共节点，也就无法得到相交节点 c1
    3.让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起
    4.这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1
     */

// 图解: https://labuladong.online/algo/essential-technique/linked-list-skills-summary-2/#%E4%B8%A4%E4%B8%AA%E9%93%BE%E8%A1%A8%E6%98%AF%E5%90%A6%E7%9B%B8%E4%BA%A4
class getIntersectionNode {
    public ListNode method(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            //
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}