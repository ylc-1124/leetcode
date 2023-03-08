package 二叉树;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class _538_把二叉搜索树转换为累加树 {
    int sum;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.right);
        sum+= root.val;
        root.val = sum;
        inorder(root.left);
    }

//    int sum = 0;
//    public TreeNode convertBST(TreeNode root) {
//        dfs(root);
//        return root;
//    }
//    /**
//     * 将以root为根节点的树的val设置为比他大的所有结点的和
//     */
//    private void dfs(TreeNode root) {
//        if (root == null) return;
//        dfs(root.right);
//        /*中序遍历代码*/
//        sum += root.val;
//        root.val = sum;
//        dfs(root.left);
//    }

}
