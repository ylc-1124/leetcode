package 二叉树;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class _450_删除二叉搜索树中的节点 {
    /**
     * 遍历所有节点，判断是否是要删除的节点
     * @return 删除完的根节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {   //当前根节点就是要删除的节点
            //待删除节点是叶子节点，直接删除
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                //右节点不为null，则找到后继结点的值替代，然后删除后继结点
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);

            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    private int successor(TreeNode root) {
        if (root == null) return 0;
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    private int predecessor(TreeNode root) {
        if (root == null) return 0;
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
