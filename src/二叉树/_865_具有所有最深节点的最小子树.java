package 二叉树;

/**
 * https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class _865_具有所有最深节点的最小子树 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return root;
        int leftMaxDepth = getMaxDepth(root.left);
        int rightMaxDepth = getMaxDepth(root.right);
        /*1、左右子树最大深度相同，意味着最深的节点都被这棵树包含了*/
        if (leftMaxDepth == rightMaxDepth) return root;
        /*2、左子树最大深度大于右子树最大深度，意味着最深的节点一定在左子树中*/
        if (leftMaxDepth > rightMaxDepth) {
            return subtreeWithAllDeepest(root.left);
        }
        /*3、不满足上面两条，意味着最深的节点只能在右子树中了*/
        return subtreeWithAllDeepest(root.right);
    }

    //求一个节点的最大深度 等价于 求这个节点为根节点的树的高度
    private int getMaxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }
}
