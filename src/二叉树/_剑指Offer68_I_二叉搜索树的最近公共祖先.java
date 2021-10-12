package 二叉树;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class _剑指Offer68_I_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        /*p,q在根节点左子树,最小公共祖先在左子树*/
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        /*p,q在根节点右子树，最小公共祖先在右子树*/
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        /*p,q节点在根节点两侧，则当前root就是最小公共祖先*/
        return root;
    }
}
