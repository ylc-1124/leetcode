package 二叉树;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class _236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /**
         * 分四种情况：
         * 1.左右同时为null，表示左右子树都没有p和q，返回null
         * 2.同时不为null，说明p，q分别位于左右两颗子树，返回root
         * 3.左为null，右不为null，表示p，q都在右子树，则right就是他们的最近公共祖先
         * 4.左非空，右空，返回left
         */
        if (left == null && right == null) {
            return null;
        } else if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }
}
