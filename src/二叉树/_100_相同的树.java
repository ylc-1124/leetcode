package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class _100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null)
                || (p != null && q == null)) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) return false;

            if (node1.left != null && node2.left != null) {
                queue1.offer(node1.left);
                queue2.offer(node2.left);
            } else if ((node1.left != null && node2.left == null)
                    || (node1.left == null && node2.left != null)) {
                return false;
            }
            if (node1.right != null && node2.right != null) {
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            } else if ((node1.right != null && node2.right == null)
                    || (node1.right == null && node2.right != null)) {
                return false;
            }
        }
        return true;
    }
}
