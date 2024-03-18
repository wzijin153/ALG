package LinkedList;

/**
 * @program: alghorithm
 * @description: K 个一组反转链表
 * @author: wangzijin
 * @create: 2024-03-18 22:13
 **/
// https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
public class reverseKGroup {
    public ListNode method(ListNode head, int k) {
        if (head == null) return null;
        ListNode left = head, right = head;
        for (int i = 0; i < k; i++) {
            if (right == null) return head;
            right = right.next;
        }
        // 翻转left到right的链表, [left, right)为一组
        ListNode newHead = reverse(left, right);
        // 递归反转剩下的[right, k)链表 -> 1个组1个组的反转
        left.next = method(right, k);
        return newHead;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    ListNode reverse(ListNode left, ListNode right) {
        ListNode pre = null;
        ListNode next;
        ListNode cur = left;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}