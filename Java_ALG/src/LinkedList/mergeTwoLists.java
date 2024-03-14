package LinkedList;

/**
 * @program: alghorithm
 * @description: 合并两个有序链表
 * @author: wangzijin
 * @create: 2024-03-14 16:08
 **/

// https://leetcode.cn/problems/merge-two-sorted-lists/description/
// 算可视化: https://labuladong.online/algo/essential-technique/linked-list-skills-summary-2/#div_merge-two-sorted-lists
class mergeTwoLists {
    public ListNode method(ListNode list1, ListNode list2) {
        // 相当于声明一个新链表存放结果
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode node1 = list1;
        ListNode node2 = list2;
        // 需要遍历两个链表, 将值较小的节点连接到cur的后面
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            }else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        // 循环结束之后, 完成了对节点数少的链表的处理, 还需要处理节点数多的链表剩余的节点
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return dummyHead.next;
    }
}
