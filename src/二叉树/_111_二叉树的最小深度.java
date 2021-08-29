package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _111_二叉树的最小深度 {
    /*使用 BFS框架，层序遍历其实是它的一种退化版*/
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size(); //记录一层有多少个节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
