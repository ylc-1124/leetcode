package 二叉树;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class _404_左叶子之和 {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        //base case
        if(root == null) return;
        //每个节点都会进行下面的判断
        //能满足下面条件的说明root.left是一个左叶子节点
        if (root.left != null
                && root.left.left == null
                && root.left.right == null) {
            sum += root.left.val;
        }
        //递归遍历左右子树
        dfs(root.left);
        dfs(root.right);
    }
}
