package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class _106_从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) {
            map.put(inorder[index], index);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                map);

    }

    private TreeNode buildTreeHelper(int[] inorder, int inBegin, int inEnd,
                                     int[] postorder, int postBegin, int postEnd,
                                     Map<Integer, Integer> map) {
        if (postBegin > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(postorder[postEnd]);
        int leftSize = index - inBegin;
        root.left = buildTreeHelper(inorder, inBegin, index - 1,
                postorder, postBegin, postBegin + leftSize - 1,
                map);
        root.right = buildTreeHelper(inorder, index + 1, inEnd,
                postorder, postBegin + leftSize, postEnd - 1,
                map);

        return root;
    }
}
