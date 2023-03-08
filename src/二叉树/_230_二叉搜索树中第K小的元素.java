package 二叉树;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class _230_二叉搜索树中第K小的元素 {
    int res;
    int count;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        if (++count == k) {
            res = root.val;
        }
        inorder(root.right, k);
    }
//    int rank = 0;
//    int res = 0;
//    public int kthSmallest(TreeNode root, int k) {
//        traverse(root, k);
//        return res;
//    }
//
//    private void traverse(TreeNode root, int k) {
//        if (root == null) return;
//        traverse(root.left, k);
//        /*中序遍历代码位置*/
//        rank++;
//        if (rank == k) {
//            res = root.val;
//            return;
//        }
//        traverse(root.right, k);
//    }
//
//
//    /*public int kthSmallest(TreeNode root, int k) {
//        List<TreeNode> list = new ArrayList<>();
//        dfs(root, list);
//        return list.get(k - 1).val;
//    }
//
//    *//**
//     * 深度优先遍历：将结点的中序遍历顺序加入列表
//     *//*
//    private void dfs(TreeNode root, List<TreeNode> list) {
//        if (root == null) return;
//        dfs(root.left, list);
//        list.add(root);
//        dfs(root.right, list);
//    }*/
}
