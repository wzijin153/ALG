package LinkedList;

/**
 * @program: alghorithm
 * @description: 定义链表
 * @author: wangzijin
 * @create: 2024-02-25 13:08
 **/

class ListNode {
    // 数据域
    int val;
    // next域, 指向下一个节点
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode head;

    //初始化链表
    public LinkedList() {
        size = 0;
        ListNode head = new ListNode(0);
    }

    // get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    // addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    // addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        // newNode.next = null; 默认指向null, 可以不要这一句
        currentNode.next = newNode;
        size++;
    }

    // addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点
    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾
    // 如果 index 大于链表长度，则不会插入节点
    // 如果 index 小于0，则在头部插入节点
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        }
        if (index == size) {
            addAtTail(val);
        }
        if (index > size) {
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode currentNode = head;
        while (index < size) {
            currentNode = currentNode.next;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
    }

    // deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        }
        ListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--;
    }
}