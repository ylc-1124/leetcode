package 二叉树;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class _543_二叉树的直径 {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    /**
     * @return 对父节点能最大贡献路径长度
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        //1、若两颗节点经过当前root节点，则直径 = 左子树的深度 + 右子树的深度
        int left = dfs(root.left);
        int right = dfs(root.right);
        //挑战最大值
        res = Math.max(res, left + right);
        //2、若当前树只有部分路径在最大路径中 , 可以贡献最多为 max{左子树高度，右子树高度} + 1 ,高度不会小于0
        return Math.max(left, right) + 1;
    }
}
