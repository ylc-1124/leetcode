package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 */
public class _1302_层数最深叶子节点的和 {
    int maxDepth;
    int ans;
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        /*当遇到一个节点的深度大于之前的最大深度，说明之前求的和不是最大层的和，清零*/
        if (depth > maxDepth) {
            maxDepth = depth;
            ans = 0;
        }
        /*当遇到层数与最大层相同，则加入总和中*/
        if (depth == maxDepth) {
            ans += root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
