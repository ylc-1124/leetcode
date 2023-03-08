package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _111_二叉树的最小深度 {

    //bfs
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size(); //一层有多少个节点
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //最早遇到的层数就是最小深度
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

//    int res = Integer.MAX_VALUE;
//
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        dfs(root, 1);
//        return res;
//    }
//
//    private void dfs(TreeNode root, int depth) {
//        if (root == null) return;
//        if (root.left == null && root.right == null) {
//            res = Math.min(res, depth);
//            return;
//        }
//        dfs(root.left, depth + 1);
//        dfs(root.right, depth + 1);
//    }

    /*使用 BFS框架，层序遍历其实是它的一种退化版*/
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int depth = 1;
//        while (!queue.isEmpty()) {
//            int size = queue.size(); //记录一层有多少个节点
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left == null && node.right == null) return depth;
//
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            depth++;
//        }
//        return depth;
//    }//
}
