package 二叉树;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        //判断一棵树是否是对称的无非是判断他的左右子树是否是镜像的
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left)
                && root1.val == root2.val;
    }
}
