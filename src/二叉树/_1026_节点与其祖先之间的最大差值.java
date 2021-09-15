package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class _1026_节点与其祖先之间的最大差值 {
    int ans;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) return;
        /*在遍历过程中更新最大最小值，继续递归遍历*/
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
        ans = Math.max(ans, max - min);
    }

}
