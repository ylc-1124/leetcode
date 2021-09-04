package 二叉树;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        return val > root.val ?
                searchBST(root.right, val) : searchBST(root.left, val);
    }
}
