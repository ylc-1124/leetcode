package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class _1123_最深叶节点的最近公共祖先 {
    Map<TreeNode, Integer> map = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        /*1、如果这棵树的左右子树深度相同，那么这颗树就是包含所有最大深度节点的树*/
        if (left == right) return root;
        /*2、左子树更深，说明最大深度的节点肯定在左子树，要找的最近公共祖先也在其中*/
        if (left > right) {
            return lcaDeepestLeaves(root.left);
        }
        /*3、执行到这说明右子树更深，与第2点同理*/
        return lcaDeepestLeaves(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        map.put(root, depth);
        return depth;
    }

}
