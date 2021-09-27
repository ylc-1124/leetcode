package 二叉树;

/**
 * https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */
public class _1379_找出克隆二叉树中的相同节点 {
    TreeNode node;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(cloned, target.val);
        return node;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;
        if (root.val == val) {
            node = root;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }
}
