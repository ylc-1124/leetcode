package 二叉树;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class _671_二叉树中第二小的节点 {

    int min = -1;
    public int findSecondMinimumValue(TreeNode root) {
        //第二小的值就是比root大的所有节点中最小的一个
        dfs(root, root.val);
        return min;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;
        if (root.val != val) {
            if (min == -1) {
                min = root.val;
            } else {
                min = Math.min(min, root.val);
            }
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }

}
