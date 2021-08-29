package 二叉树;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表 {
    /**
     *  将root为根节点的树 拉平成链表
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode node = root;

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.right = left;
        node.left = null;

        while (node.right != null) {
            node = node.right;
        }
        node.right = right;

    }
}
