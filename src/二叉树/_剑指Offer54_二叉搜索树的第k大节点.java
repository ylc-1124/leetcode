package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class _剑指Offer54_二叉搜索树的第k大节点 {
    int res;
    int count;
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;
        dfs(root.right, k);
        if (++count == k) {
            res = root.val;
        }
        dfs(root.left, k);
    }
}
