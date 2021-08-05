package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    private void preorder(TreeNode root, List list) {
        if (root==null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
