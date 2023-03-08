package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        //树的最大深度=max(左子树最大深度，右子树最大深度)+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

//    /**
//     * 求出以root为根节点的树的最大深度(递归解法)
//     */
//    public int maxDepth1(TreeNode root) {
//        if (root == null) return 0;
//        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
//    }
//
//    /**
//     * 层序遍历
//     */
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            int levelSize = queue.size();
//            for (int i = 0; i < levelSize; i++) {
//                TreeNode node = queue.poll();
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
//    }

}
