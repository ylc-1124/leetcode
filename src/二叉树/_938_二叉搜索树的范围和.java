package 二叉树;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class _938_二叉搜索树的范围和 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        //base case
        if (root == null) return 0;

        //求出左右子树在这个范围的和
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);

        if (root.val >= low && root.val <= high) {
            return left + right + root.val;
        } else {
            return left + right;
        }
    }

}
