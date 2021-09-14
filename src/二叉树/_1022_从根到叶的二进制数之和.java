package 二叉树;

/**
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class _1022_从根到叶的二进制数之和 {
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    private void dfs(TreeNode root,int sum) {
        if (root == null) return;
        sum = (sum << 1) + root.val;
        if (root.left == null && root.right == null) {
            ans += sum;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
