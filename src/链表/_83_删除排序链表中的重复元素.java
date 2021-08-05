package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next =null;
        ListNode node = new _83_删除排序链表中的重复元素().deleteDuplicates(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
