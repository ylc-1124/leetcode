package 树;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }
}
