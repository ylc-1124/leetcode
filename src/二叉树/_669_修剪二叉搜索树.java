package 二叉树;

/**
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class _669_修剪二叉搜索树 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        //需要删除的无非就是这两种情况，要分开讨论
        if (root.val < low ) {
            //左子树必然也不满足，右子树有可能不满足,进行一次对其右子树的遍历，
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            //同理
            return trimBST(root.left, low, high);
        }
        root.right = trimBST(root.right, low, high);
        root.left = trimBST(root.left, low, high);
        return root;
    }
}
