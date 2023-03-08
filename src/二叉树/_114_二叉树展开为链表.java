package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表 {
    //labuladong大佬的方法，牛皮
    public void flatten(TreeNode root) {
        if (root == null) return;
        //1、左右子树拉平
        flatten(root.left);
        flatten(root.right);
        //2、拉平后的左子树作为新的右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;
        root.left = null;
        //3、旧的右子树接在新的右子树后面
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
//    Queue<TreeNode> queue = new LinkedList<>();
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        dfs(root);
//        //节点前序遍历的顺序在队列中排好队了，现在开始拉平处理
//        TreeNode prev = null;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            node.left = null;
//            node.right = null;
//            if (prev != null) {
//                prev.right = node;
//            }
//            prev = node;
//        }
//
//    }
//
//    private void dfs(TreeNode root) {
//        if (root == null) return;
//        queue.offer(root);
//        dfs(root.left);
//        dfs(root.right);
//    }

//    TreeNode last = null;
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        flatten(root.right);
//        flatten(root.left);
//        root.left = null;
//        root.right = last;
//        last = root;
//    }


//    /**
//     *  将root为根节点的树 拉平成链表
//     */
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//
//        flatten(root.left);
//        flatten(root.right);
//
//        TreeNode node = root;
//
//        TreeNode left = node.left;
//        TreeNode right = node.right;
//
//        node.right = left;
//        node.left = null;
//
//        while (node.right != null) {
//            node = node.right;
//        }
//        node.right = right;
//
//    }
}
