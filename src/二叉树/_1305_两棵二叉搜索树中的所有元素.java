package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
public class _1305_两棵二叉搜索树中的所有元素 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        res.sort((o1, o2) -> o1 - o2);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root==null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
