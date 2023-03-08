package 二叉树;


import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
    List<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
//        return list;
//    }
//
//    private void inorder(TreeNode node, List<Integer> list) {
//        if (node == null) return;
//        inorder(node.left, list);
//        //...
//        list.add(node.val);
//        inorder(node.right, list);
//    }
}
