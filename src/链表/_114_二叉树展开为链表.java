package 链表;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode newRoot = new TreeNode();
        TreeNode tail = newRoot;
        traversal(root,queue);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = node.right = null;
            tail.right = node;
            tail = node;
        }
        root = newRoot.right;
    }

    private void traversal(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) return;
        queue.offer(node);
        traversal(node.left, queue);
        traversal(node.right, queue);
    }
}
