package 链表;

/**
 * https://leetcode-cn.com/problems/partition-list/
 */
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode large = new ListNode(), largePtr = large;
        ListNode small = new ListNode(), smallPtr = small;
        ListNode node = head;
        ListNode tmp = null;
        while (node != null) {
            tmp = node.next;
            node.next = null;
            if (node.val < x) {
                smallPtr.next = node;
                smallPtr = node;
            } else {
                largePtr.next = node;
                largePtr = node;
            }
                node = tmp;
        }
        smallPtr.next = large.next;

        return small.next;
    }

}
