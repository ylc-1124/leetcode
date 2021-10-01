package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/balance-a-binary-search-tree/
 */
public class _1382_将二叉搜索树变平衡 {
    List<Integer> list = new LinkedList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return buildBST(list, 0, list.size());
    }

    /**
     * 左闭右开
     */
    private TreeNode buildBST(List<Integer> list, int begin, int end) {
        if (begin >= end) return null;
        int mid = (begin + end) >> 1;
        //中间节点作为根节点
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBST(list, begin, mid);
        root.right = buildBST(list, mid + 1, end);
        return root;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
