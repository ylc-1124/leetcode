package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null) return false;
        ListNode slow = head;   //慢指针
        ListNode fast = head.next; //快指针
        while (fast!=null&&fast.next!=null) {
            if (slow==fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
