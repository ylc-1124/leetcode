package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/add-one-row-to-tree/
 */
public class _623_在二叉树中增加一行 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (level == depth - 1) {
                //给队列中的每个节点都添加新的节点
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    TreeNode oldLeft = node.left;
                    TreeNode oldRight = node.right;
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = oldLeft;
                    node.right.right = oldRight;
                }
                break;
            } else {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                level++;
            }
        }
        return root;
    }
}
