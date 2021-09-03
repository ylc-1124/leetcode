package 二叉树;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class _124_二叉树中的最大路径和 {
    int result = Integer.MIN_VALUE;
    /**
     * 求出以root为根节点的树的最大路径和
     */
    public int maxPathSum(TreeNode root) {
        //因为这棵树的最大路径和 并不一定过传入的这个root结点，所以这里需要个辅助函数遍历每一个结点
        dfs(root);
        return result;
    }

    /**
     * @return 对父节点最大贡献
     */
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        /*1、当前树本身可能就是我们要求的路径和最大的树，
        当前树的最大路径和 = 左子树的最大路径和 + 右子树的最大路径和 + 根节点值*/
        int left = dfs(root.left);
        int right = dfs(root.right);
        //挑战已知的最大路径和
        result = Math.max(result, root.val + left + right);

        /*2、当前树很有可能是其他树的子树的一部分，后面代码要求出的其实就是能对父节点做出的最大贡献
        当前树是属于要求的最大路径和经过的一部分的话，那么首先他一定不能有分支，路径是不能走回头路的！！！题目精髓所在，细品
        当前树的最大贡献值 = max{左子树的最大贡献 , 右子树的最大贡献} + 根节点值 */
        int contribution = root.val + Math.max(left, right);
        //小细节：如果贡献的是个负数，则返回一个0，跟null一样处理，当作没有这条分支可以选择
        return contribution > 0 ? contribution : 0;
    }
}
