package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class _82_删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0, head);
        ListNode node = head;
        ListNode next = node.next;
        ListNode prev = newHead;

        while (node != null && next != null) {
            if (node.val != next.val) { //不重复则继续往后面遍历
                prev = node;
                node = node.next;
                if (node != null) {
                    next = node.next;
                }
                continue;
            }
            //node.val是重复的值,next指针移动到一一个大于这个值的位置
            while (next != null && next.val == node.val) {
                next = next.next;
            }
            //next指向第一个不等于这个重复值的结点
            prev.next = next;
            node = next;
            if (node != null) {
                next = node.next;
            }
        }
        return newHead.next;
    }

}
