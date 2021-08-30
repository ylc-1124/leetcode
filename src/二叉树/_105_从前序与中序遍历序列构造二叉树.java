package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        /*map里面存放中序遍历结果对应的索引*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preBegin, int preEnd
            , int[] inorder, int inBegin, int inEnd,Map<Integer,Integer> map) {

        if (preBegin > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preBegin]);
        /*查找根节点在中序遍历的位置*/
        int index = 0;
        index = map.get(root.val);
        /*左子树的节点个数*/
        int leftSize = index - inBegin;
        root.left = buildTreeHelper(preorder, preBegin + 1, preBegin + leftSize
                , inorder, inBegin, index - 1, map);
        root.right = buildTreeHelper(preorder, preBegin + leftSize + 1, preEnd,
                inorder, index + 1, inEnd, map);
        return root;
    }
}
