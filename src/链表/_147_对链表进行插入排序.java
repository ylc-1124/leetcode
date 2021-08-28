package 链表;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class _147_对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null ||head.next == null) return head;
        ListNode newHead = new ListNode(0, head);
        ListNode prev = newHead; //待插入位置的前趋节点
        ListNode node = head.next; // 待插入节点
        ListNode lastSorted = head; //指向排序好部分的最后一个节点
        while (node != null) {
            if (node.val >= lastSorted.val) {
                lastSorted = node;
                node = node.next;
            } else {
                while (prev.next.val < node.val) {
                    prev = prev.next;
                }
                lastSorted.next = node.next;
                node.next = prev.next;
                prev.next = node;

                node = lastSorted.next;
                prev = newHead;
            }

        }
        return newHead.next;
    }
}
