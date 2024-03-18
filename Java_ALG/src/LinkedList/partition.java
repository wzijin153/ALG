package LinkedList;

/**
 * @program: alghorithm
 * @description: 分隔链表
 * @author: wangzijin
 * @create: 2024-03-14 16:08
 **/
// https://leetcode.cn/problems/partition-list/

// 分成两步
// 1.连接值小于x的节点
// 2.连接值大于x的节点
class partition {
    public ListNode method(ListNode head, int x) {
        // dummyHead存放小于x的节点
        ListNode dummyHead = new ListNode(0);
        // dummyTail存放大于x的节点
        ListNode dummyTail = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode tail = dummyTail;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                cur.next = node;
                cur = cur.next;
            }else {
                tail.next = node;
                tail = tail.next;
            }
            node = node.next;
        }
        // TODO tail.next = null的含义
        /*
        * 目的是将大于等于 x 的节点之后的部分截断，即将链表的尾部置为 null
        * 在链接大于等于 x 的节点时，我们使用了一个虚拟的尾节点 dummyTail，但在最终返回结果时，我们不需要包含这个尾部节点，所以需要将其后的部分截断
        * 假设链表中原来的结构为：... -> A -> B -> C -> D -> E -> ...，其中 A、B、C、D、E 是节点，而 tail 指向节点 C，dummyTail 指向节点 E
        * 在执行 tail.next = null; 后，链表的结构变为：... -> A -> B -> C -> D -> null，即将节点 E 之后的部分截断了
        * */
        tail.next = null;
        // 将小于 x 的节点链接到大于等于 x 的节点之前
        cur.next = dummyTail.next;
        return dummyHead.next;
    }
}
