package LinkedList;

import java.util.PriorityQueue;

/**
 * @program: alghorithm
 * @description: 合并 K 个升序链表
 * @author: wangzijin
 * @create: 2024-03-17 15:46
 **/
// https://leetcode.cn/problems/merge-k-sorted-lists/

/*
    思路：
    1.创建优先队列（PriorityQueue），并指定了一个比较器，用于按照节点的值进行比较
    2.将所有链表的头节点加入优先队列
    3.从优先队列中取出最小节点，并将其后续节点加入优先队列，直到优先队列为空
 */
public class mergeKLists {
    public ListNode method(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        /*
            1.PriorityQueue<ListNode>: 创建存放ListNode的优先队列, 可以确保每次取出的元素都是队列中最小（或最大）的元素
            2.new PriorityQueue<>((a, b) -> a.val - b.val): 指定比较器, 用于比较两个ListNode对象的大小(比较器的作用是用来确定元素的优先级顺序)
            3.如果节点a的val字段值小于节点b的val字段值，则返回负值; 如果节点a的val字段值等于节点b的val字段值，则返回0; 如果节点a的val字段值大于节点b的val字段值，则返回正值
            4.在 PriorityQueue 中，元素的优先级是按照它们的 val 值升序排列的; 也就是说，队列中的最小元素（val 最小的元素）会被优先取出
         */
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        // 将所有链表的头节点加入优先队列
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        // 从优先队列中依次取出最小节点，并将其后续节点加入优先队列
        while (!queue.isEmpty()) {
            // TODO 为什么弹出的一定是最小值
            ListNode minNode = queue.poll();// 弹出最小值,并将其从队列中移除
            cur.next = minNode;
            cur = cur.next;
            // 将当前节点所属链表的下一个节点加入队列中
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }
}