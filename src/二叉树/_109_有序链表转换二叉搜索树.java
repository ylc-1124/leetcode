package 二叉树;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class _109_有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head, null);
    }

    /**
     *  范围 [ head , tail)
     */
    private TreeNode buildBST(ListNode head, ListNode tail) {
        if (head == null || head == tail) return null;
        if (head.next == tail) return new TreeNode(head.val);
        ListNode middleNode = middleNode(head, tail);
        TreeNode root = new TreeNode(middleNode.val);

        root.left = buildBST(head, middleNode);
        root.right = buildBST(middleNode.next,tail);

        return root;
    }
    private ListNode middleNode(ListNode head,ListNode tail) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        /*slow指向中点*/
        return slow;
    }
}
