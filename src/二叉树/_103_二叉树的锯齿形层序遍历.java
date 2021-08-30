package 二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class _103_二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        bfs(root, res);
        return res;
    }

    private void bfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            /*双端队列存储*/
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOrderLeft) {
                    deque.offerLast(node.val);
                }else {
                    deque.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(new LinkedList<>(deque));
            isOrderLeft = !isOrderLeft;

        }

    }
}
