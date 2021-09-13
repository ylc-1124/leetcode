package 二叉树;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree-ii/
 */
public class _998_最大二叉树II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || val > root.val) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
