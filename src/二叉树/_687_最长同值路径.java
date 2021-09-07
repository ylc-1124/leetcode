package 二叉树;

/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 */
public class _687_最长同值路径 {
    int res;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    /**
     * 求出与父节点值相同的同值路径和
     * @param root  要遍历的树的根节点
     * @param val  父节点的值
     * @return 同值路径和
     */
    private int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        res = Math.max(res, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }

}
