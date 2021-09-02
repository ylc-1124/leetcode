package 链表;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class _138_复制带随机指针的链表 {
    public Node copyRandomList(Node head) {
        Node cur = head;  //指向原链表
        Node dummy = new Node(0);
        Node tail = dummy;
        while (cur != null) {
            //创建一个和cur相同的结点
            Node node = new Node(cur.val);
            //让新结点成为他的后继
            node.next = cur.next;
            cur.next = node;

            cur = node.next;
        }
        //至此原链表结点后面都新增了一个新结点
        cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            if (cur.random != null) {
                next.random = cur.random.next;
            }
            cur = next.next;
        }
        //分离链表
        cur = head;
        next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = next.next;
            cur = cur.next;
            //链接到新链表,尾插法
            tail.next = next;
            tail = next;
        }
        return dummy.next;
    }
}
