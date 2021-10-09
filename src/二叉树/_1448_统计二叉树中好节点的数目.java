package 二叉树;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree/
 */
public class _1448_统计二叉树中好节点的数目 {
    int res;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return res;
    }

    private void dfs(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            res++;
            max= root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
