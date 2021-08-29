package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class _112_路径总和 {
    /**
     *  判断从根节点到叶子节点路径总和能否与目标值相等
     * @param root 根节点
     * @param targetSum 目标值
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        /*如果节点是叶子节点，判断它所包含的值是否是所需要的值*/
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        /*当前树根节点左右子树递归，目标值减去根节点值*/
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
