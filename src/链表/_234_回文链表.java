package 链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class _234_回文链表 {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }
    public boolean isPalindrome1(ListNode head) {
        if (head == null) return true;
        ListNode newHead = new ListNode(0, null);
        ListNode node = head;
        ListNode newNode = null;
        while (node != null) {
            newNode = new ListNode(node.val, newHead.next);
            newHead.next = newNode;
            node = node.next;
        }
        node = head;
        newNode = newHead.next;
        while (node != null && newNode != null) {
            if (node.val!= newNode.val) return false;
            node = node.next;
            newNode = newNode.next;
        }
        return true;
    }
}
