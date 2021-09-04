package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class _530_二叉搜索树的最小绝对差 {
    int prev = -1;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        //BST中序遍历顺序是从小到大的
        if (prev != -1) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        dfs(root.right);
    }
}
