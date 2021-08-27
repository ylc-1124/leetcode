package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode begin = head, end = head;
        //需要反转的元素范围 [ begin , end )
        for (int i = 0; i < k; i++) {
            if (end == null) return head;
            end = end.next;
        }
        ListNode newHead = reverse(begin, end);
        begin.next = reverseKGroup(end, k);
        return newHead;
    }

    private ListNode reverse(ListNode head,ListNode tail) {
        if (head == tail) return tail;
        ListNode prev = null, cur = head, next = head;
        while (cur != tail) {
            next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
