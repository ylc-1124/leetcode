package 二叉树;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 */
public class _701_二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
