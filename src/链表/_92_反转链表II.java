package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class _92_反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode newHead = new ListNode(0, head);
        ListNode node = head;
        ListNode prev = newHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        node = prev.next;
        //node移动到待反转位置
        ListNode cur = node.next;
        for (int i = 0; i < right - left; i++) {
            node.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = node.next;
        }
        return newHead.next;
    }
}
