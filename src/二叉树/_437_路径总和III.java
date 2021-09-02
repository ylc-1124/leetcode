package 二叉树;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 */
public class _437_路径总和III {
    int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        sum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return result;
    }

    private void sum(TreeNode root, int targetSum) {
        if (root == null) return ;
        if (root.val == targetSum) {
            result++;
        }
        sum(root.left, targetSum - root.val);
        sum(root.right, targetSum - root.val);
    }


}
