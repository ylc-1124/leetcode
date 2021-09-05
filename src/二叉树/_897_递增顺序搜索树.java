package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class _897_递增顺序搜索树 {
    public TreeNode increasingBST(TreeNode root) {
        if (root.left == null && root.right == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        dfs(root, queue);
        TreeNode newRoot = null;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = node.right = null;
            if (newRoot == null) {
                newRoot = node;
                cur = newRoot;
            }
            cur.right = node;
            cur = node;

        }
        return newRoot;
    }

    private void dfs(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) return;
        dfs(root.left, queue);
        queue.offer(root);
        dfs(root.right, queue);
    }
}
