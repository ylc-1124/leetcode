package 二叉树;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class _572_另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot)
                || isSameTree(root, subRoot);
    }

    /**
     * 判断以root为根节点树是否与以subRoot为根节点相同
     */
    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        //base case
        if (root == null && subRoot == null) return true;
        else if (root == null || subRoot == null) {
            return false;
        }
        return isSameTree(root.left, subRoot.left)
                && isSameTree(root.right, subRoot.right)
                && root.val == subRoot.val;

    }
}
