package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class _515_在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
    }
}
