package 链表;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class _143_重排链表 {
    ListNode left;
    public void reorderList(ListNode head) {
        left = head;
        traversal(head);
    }

    private void traversal(ListNode node) {
        if (node == null) return;
        traversal(node.next); //链表后序遍历 拿到最后一个结点
        //结束条件
        if (left == null ) return;
        if (left == node) {
            left.next = null;
            left = null;
            return;
        }
        if (left.next != node) {
            node.next = left.next;
            left.next = node;
            left = node.next;
        } else {
            node.next = null;
            left = null;
        }
    }
}
