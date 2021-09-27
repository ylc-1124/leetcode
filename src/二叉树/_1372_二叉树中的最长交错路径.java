package 二叉树;

/**
 * https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class _1372_二叉树中的最长交错路径 {
    int max;
    public int longestZigZag(TreeNode root) {
        dfs(root, true);
        return max;
    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        int left = dfs(root.left, true);
        int right = dfs(root.right, false);
        max = Math.max(max, Math.max(left, right));
        if (isLeft) {
            return right + 1;
        } else {
            return left + 1;
        }
    }
}
