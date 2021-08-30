package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */
public class _129_求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        return backtrack(root, 0);
    }
    private int backtrack(TreeNode root, int prevSum) {
        if (root == null) return 0;
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return backtrack(root.left, sum) + backtrack(root.right, sum);
        }
    }

}
