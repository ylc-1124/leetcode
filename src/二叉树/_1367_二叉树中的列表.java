package 二叉树;

/**
 * https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 */
public class _1367_二叉树中的列表 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return dfs(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (root.val != head.val) return false;
        return dfs(head.next, root.left)
                || dfs(head.next, root.right);
    }
}
