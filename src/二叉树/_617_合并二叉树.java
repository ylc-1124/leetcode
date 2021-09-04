package 二叉树;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class _617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //base case
        if (root1 == null && root2 == null) return null;
        if (root1 == null) return root2;
        else if (root2 == null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
