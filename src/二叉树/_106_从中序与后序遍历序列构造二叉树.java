package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inBegin, int inEnd,
                               int[] postorder, int postBegin, int postEnd) {
        if (inBegin > inEnd) return null;
        //1、postorder[postEnd]就是根节点
        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);

        //2、找出val在中序遍历的位置-->确定好左右子树-->分别递归建树
        int index = map.get(val);
        int leftSize = index - inBegin;
        root.left = buildTree(inorder, inBegin, index - 1,
                postorder, postBegin, postBegin + leftSize - 1);
        root.right = buildTree(inorder, index + 1, inEnd,
                postorder, postBegin + leftSize, postEnd - 1);

        return root;
    }

//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (inorder == null || postorder == null) return null;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int index = 0; index < inorder.length; index++) {
//            map.put(inorder[index], index);
//        }
//        return buildTreeHelper(inorder, 0, inorder.length - 1,
//                postorder, 0, postorder.length - 1,
//                map);
//
//    }
//
//    private TreeNode buildTreeHelper(int[] inorder, int inBegin, int inEnd,
//                                     int[] postorder, int postBegin, int postEnd,
//                                     Map<Integer, Integer> map) {
//        if (postBegin > postEnd) return null;
//        TreeNode root = new TreeNode(postorder[postEnd]);
//        int index = map.get(postorder[postEnd]);
//        int leftSize = index - inBegin;
//        root.left = buildTreeHelper(inorder, inBegin, index - 1,
//                postorder, postBegin, postBegin + leftSize - 1,
//                map);
//        root.right = buildTreeHelper(inorder, index + 1, inEnd,
//                postorder, postBegin + leftSize, postEnd - 1,
//                map);
//
//        return root;
//    }
}
