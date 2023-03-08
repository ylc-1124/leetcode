package 二叉树;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class _450_删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            //找到了待删除节点
            //1、当前节点是叶子节点
            if (root.left == null && root.right == null) return null;

            //2、当前节点只有一个孩子节点，让非空孩子代替自己
            if (root.left!=null&&root.right==null) return root.left;
            else if (root.left == null) return root.right;

            //3、左右子树都不为空，最麻烦的情况
            //找左子树最大的或者右子树最小的替代自己
            TreeNode min = getMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);

        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

//    /**
//     * 遍历以root为根节点树中的所有节点，找到值为key的，删除
//     * @return 删除完后树的根节点
//     */
//    public TreeNode deleteNode(TreeNode root, int key) {
//        //base case
//        if (root == null) return null;
//
//        if (root.val == key) {
//            /*1、待删除节点是叶子节点--直接删除*/
//            if (root.left == null && root.right == null) return null;
//            /*2、待删除节点左子树为空，右子树非空--找到他的后继节点*/
//            if (root.right != null) {
//                root.val = successor(root);
//                root.right = deleteNode(root.right, root.val);
//            } else {
//                /*3、待删除节点左右子树都为空，或者左子树不为空--找到他的前趋节点*/
//                root.val = predecessor(root);
//                root.left = deleteNode(root.left, root.val);
//            }
//        } else if (key > root.val) {
//            root.right = deleteNode(root.right, key);
//        } else {
//            root.left = deleteNode(root.left, key);
//        }
//
//        return root;
//    }
//
//    /**
//     * 后继节点的值
//     */
//    private int successor(TreeNode root) {
//        if (root == null) return 0;
//        root = root.right;
//        while (root.left != null) {
//            root = root.left;
//        }
//        return root.val;
//    }
//    /**
//     * 后继节点的值
//     */
//    private int predecessor(TreeNode root) {
//        if (root == null) return 0;
//        root = root.left;
//        while (root.right != null) {
//            root = root.right;
//        }
//        return root.val;
//    }
//


}
