package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
public class _783_二叉搜索树节点最小距离 {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfs(root,list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < min) {
                min = list.get(i) - list.get(i - 1);
            }
        }
        return min;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }



}
