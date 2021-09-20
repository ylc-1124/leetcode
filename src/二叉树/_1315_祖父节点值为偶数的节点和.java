package 二叉树;

/**
 * https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class _1315_祖父节点值为偶数的节点和 {
    int res;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return res;
    }

    private void dfs(TreeNode root, TreeNode parent, TreeNode grandparent) {
        if (root == null) return;
        if (grandparent != null
                && grandparent.val % 2 == 0) {
            res += root.val;
        }
        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }

}
