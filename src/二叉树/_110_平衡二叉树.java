package 二叉树;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class _110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return Math.abs(height(root.left) - height(root.right))<=1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node==null) return 0;
        int left = height(node.left);  //左子树深度
        int right = height(node.right); //右子树深度
        return Math.max(left, right) + 1;
    }
}
