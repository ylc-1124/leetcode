package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class _257_二叉树的所有路径 {
    List<String> result = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        String track = new String();
        backtrack(root, track);
        return result;
    }

    private void backtrack(TreeNode root, String track) {
        if (root == null) return;
        /*做选择*/
        track += root.val;
        if (root.left == null && root.right == null) {
            result.add(track);
            return;
        }
        backtrack(root.left, track+"->");
        backtrack(root.right, track + "->");

    }
}
