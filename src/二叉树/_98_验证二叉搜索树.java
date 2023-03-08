package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class _98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) return true;
        //符合下面条件说明此节点符合二叉搜索树的性质
        if (max != null && root.val > max.val) return false;
        if (min != null && root.val < min.val) return false;
        //左右子树也符合，说明以root为根节点二叉树符合二叉搜索树的性质
        return isValidBST(root.left, root, min)
                && isValidBST(root.right, max, root);
    }
//    /**
//     * 判断以root为根节点的树是否符合二叉搜索树特点
//     * 左子树所有节点的值全部小于 root的值
//     * 右子树所有节点的值全部大于 root的值
//     */
//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, null, null);
//    }
//
//    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
//        if (root == null) return true;
//        if (min != null && root.val <= min.val) return false;
//        if (max != null && root.val >= max.val) return false;
//
//        return isValidBST(root.left, min, root)
//                && isValidBST(root.right, root, max);
//    }

}
