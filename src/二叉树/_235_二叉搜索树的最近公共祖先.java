package 二叉树;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class _235_二叉搜索树的最近公共祖先 {
    /**
     * 找到p，q结点最近公共结点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val- p.val)*(root.val- q.val)<=0) return root;
        return p.val < root.val ?
                lowestCommonAncestor(root.left, p, q) :
                lowestCommonAncestor(root.right, p, q);
    }
}
