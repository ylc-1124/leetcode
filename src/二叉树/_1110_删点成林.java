package 二叉树;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/delete-nodes-and-return-forest/
 */
public class _1110_删点成林 {
    List<TreeNode> res = new LinkedList<>();
    Set<Integer> toDelete = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int val : to_delete) {
            toDelete.add(val);
        }
        if (!toDelete.contains(root)) {
            res.add(root);
        }
        dfs(root);
        return res;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
