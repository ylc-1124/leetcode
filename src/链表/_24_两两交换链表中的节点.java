package 链表;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class _24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0, head);
        ListNode node = head;
        ListNode next = node.next;
        ListNode prev = newHead;
        while (node != null && next != null) {
            //交换
            node.next = next.next;
            next.next = node;
            prev.next = next;

            prev = node;
            node = node.next;
            if (node != null) {
                next = node.next;
            }
        }

        return newHead.next;
    }
}
