package 二叉树;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class _1038_把二叉搜索树转换为累加树 {
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }
}
