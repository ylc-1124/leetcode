package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */
public class _222_完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {
        //base case
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
