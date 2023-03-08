package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    //存放inorder的值对应的索引
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * 通过前序遍历和中序遍历序列建树
     */
    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd,
                               int[] inorder, int inBegin, int inEnd) {
        if (preBegin > preEnd) return null;

        //1、preorder[preBegin]就是根节点的值
        int val = preorder[preBegin];
        TreeNode root = new TreeNode(val);

        //2、找到根节点值在inorder中的位置，左边就是左子树，右边就是右子树
        int index = map.get(val);
        //3、确定左子树长度
        int leftSize = index - inBegin;

        //4、递归建立左子树和右子树，接上
        root.left = buildTree(preorder, preBegin + 1, preBegin + leftSize,
                inorder, inBegin, index - 1);
        root.right = buildTree(preorder, preBegin + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || inorder == null) return null;
//        /*map里面存放中序遍历结果对应的索引*/
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return buildTreeHelper(preorder, 0, preorder.length - 1,
//                inorder, 0, inorder.length - 1, map);
//    }
//
//    private TreeNode buildTreeHelper(int[] preorder, int preBegin, int preEnd
//            , int[] inorder, int inBegin, int inEnd,Map<Integer,Integer> map) {
//
//        if (preBegin > preEnd) return null;
//        TreeNode root = new TreeNode(preorder[preBegin]);
//        /*查找根节点在中序遍历的位置*/
//        int index = map.get(root.val);
//        /*左子树的节点个数*/
//        int leftSize = index - inBegin;
//        root.left = buildTreeHelper(preorder, preBegin + 1, preBegin + leftSize
//                , inorder, inBegin, index - 1, map);
//        root.right = buildTreeHelper(preorder, preBegin + leftSize + 1, preEnd,
//                inorder, index + 1, inEnd, map);
//        return root;
//    }

}
