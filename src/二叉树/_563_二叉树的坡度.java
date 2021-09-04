package 二叉树;


/**
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 */
public class _563_二叉树的坡度 {
    int result;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return result;
    }
    /**
     * 求出当前节点的坡度累加进result中
     * @return 以root为根节点的所有节点的值
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }
}
