package 链表;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class _61_旋转链表 {
    /**
     * 快慢指针
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = fast;
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        for (int i = 0; i < k % len; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //到这slow指向的结点作为尾结点
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }

}
