package 二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    TreeNode cur;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();

    }

    public int next() {
        while (cur != null) { //cur不为空则一直往左下走
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }
}
