package 二叉树;

/**
 * https://leetcode-cn.com/problems/distribute-coins-in-binary-tree/
 */
public class _979_在二叉树中分配硬币 {
    int count;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return count;
    }

    /**
     * @return 当前节点为根节点的树可以向上反馈的金币数量(可正可负，姑且叫他正反馈和负反馈)
     *         正反馈--当前节点可以给父节点贡献的金币数量
     *         负反馈--当前节点需要从父节点获得的金币数量
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        /*总移动次数的次数恰巧是左右子树正负反馈的绝对值之和*/
        count += Math.abs(left) + Math.abs(right);
        return root.val - 1 + left + right;
    }
}
