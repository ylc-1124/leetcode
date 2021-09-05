package 二叉树;

/**
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 */
public class _965_单值二叉树 {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;
        return isUnivalTree(root.left, val)
                && isUnivalTree(root.right, val)
                && root.val == val;
    }
}
