package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class _113_路径总和II {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(root, targetSum, track);
        return res;
    }
    /**
     * 回溯法
     */
    private void backtrack(TreeNode root, int targetSum, LinkedList<Integer> track) {
        if (root == null) return;
        /*做选择*/
        track.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            res.add(new LinkedList<>(track));
        }
        backtrack(root.left, targetSum - root.val, track);
        backtrack(root.right, targetSum - root.val, track);
        track.removeLast();

    }
}
