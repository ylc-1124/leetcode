package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class _1161_最大层内元素和 {
    Map<Integer, Integer> map = new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        dfs(root, 1);
        int maxSum = Integer.MIN_VALUE;
        int ans = 1;
        for (Integer depth : map.keySet()) {
            Integer levelSum = map.get(depth);
            if (levelSum > maxSum) {
                maxSum = levelSum;
                ans = depth;
            }
        }
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        map.put(depth, map.getOrDefault(depth, 0) + root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
