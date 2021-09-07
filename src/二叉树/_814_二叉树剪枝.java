package 二叉树;

/**
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 */
public class _814_二叉树剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode root) {
        if (root == null) return false;
        //判断左右子树有没有包含 1
        boolean left = containsOne(root.left);
        boolean right = containsOne(root.right);
        //如果左子树没有包含 1 左子树置空，右子树同理
        if (!left) root.left = null;
        if (!right) root.right = null;
        return root.val == 1 || left || right;
    }
}
