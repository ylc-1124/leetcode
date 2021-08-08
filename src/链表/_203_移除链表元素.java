package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return head;
        ListNode visualHead = new ListNode(0, head);
        ListNode cur = visualHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {   //必须用else不然会多走，少比较
                cur = cur.next;
            }
        }
        return visualHead.next;
    }
}
