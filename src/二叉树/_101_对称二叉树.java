package 二叉树;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val!=right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }
}
