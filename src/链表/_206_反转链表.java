package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
    public ListNode reverseList1(ListNode head) { // 递归
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
