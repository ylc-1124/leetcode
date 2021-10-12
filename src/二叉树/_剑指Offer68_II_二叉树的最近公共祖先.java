package 二叉树;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class _剑指Offer68_II_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        //递归到p或q节点就返回
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //p,q在一左一右
        if (left != null && right != null) return root;
        //p,q都在右子树，最近公共祖先在右子树
        if (left == null) return right;

        //p,q都在左子树，最近公共祖先在左子树
        return left;
    }
}
