package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class _993_二叉树的堂兄弟节点 {
    int xDepth, yDepth;
    TreeNode xParent, yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        //两个节点深度相同且父节点不同则是堂兄弟节点
        dfs(root,null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
        if (root == null) return;
        /*如果当前节点是x或者y，记录一下*/
        if (root.val == x) {
            xParent = parent;
            xDepth = depth;
        } else if (root.val == y) {
            yParent = parent;
            yDepth = depth;
        }
        dfs(root.left, root, x, y, depth + 1);
        dfs(root.right, root, x, y, depth + 1);

    }
}
