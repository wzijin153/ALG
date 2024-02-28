package LinkedList;

/**
 * @program: alghorithm
 * @description: 移除链表元素
 * @author: wangzijin
 * @create: 2024-02-25 13:13
 **/

// https://leetcode.cn/problems/remove-linked-list-elements/
// 删除链表中等于给定值 val 的所有节点。
// 示例 1： 输入：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
// 示例 2： 输入：head = [], val = 1 输出：[]
// 示例 3： 输入：head = [7,7,7,7], val = 7 输出：[]

class removeElements {
    public ListNode method(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
//        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}