package 二叉树;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class _101_对称二叉树 {
    /**
     * 判断一棵树是否对称
     * 只需要判断他的左右子树是否是镜像的
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    /**
     * 判断两棵树是否镜像相等
     * 1、判断两棵树根节点是否相等
     * 2、判断左右子树是否镜像相等
     */
    private boolean isMirror(TreeNode root1, TreeNode root2) {
        //同时为空返回true，一个为空一个不为空返回false
        if (root1==null&&root2==null) return true;
        else if (root1 == null || root2 == null) return false;

        return root1.val == root2.val
                && isMirror(root1.right, root2.left)
                && isMirror(root1.left, root2.right);
    }

//    public boolean isSymmetric(TreeNode root) {
//        //判断一棵树是否是对称的无非是判断他的左右子树是否是镜像的
//        return isMirror(root.left, root.right);
//    }
//
//    private boolean isMirror(TreeNode root1, TreeNode root2) {
//        if(root1 == null && root2 == null) return true;
//        if (root1 == null || root2 == null) return false;
//
//        return isMirror(root1.left, root2.right)
//                && isMirror(root1.right, root2.left)
//                && root1.val == root2.val;
//    }
}
