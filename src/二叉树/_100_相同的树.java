package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/same-tree/
 */
public class _100_相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //base case
        if (p == null && q == null) return true;
        //p，q只有一个为null，返回false
        else if (p == null || q == null) return false;

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);

    }
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null) return q == null;
//        if (q == null) return false;
//
//        boolean left = isSameTree(p.left, q.left);
//        boolean right = isSameTree(p.right, q.right);
//
//        /*后续遍历代码*/
//        return left && right && p.val == q.val;
//    }
}
