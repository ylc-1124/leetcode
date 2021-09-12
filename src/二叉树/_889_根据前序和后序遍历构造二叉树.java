package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class _889_根据前序和后序遍历构造二叉树 {

    Map<Integer, Integer> preorderMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < preorder.length; i++) {
            preorderMap.put(preorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd,
                               int[] postorder, int postBegin, int postEnd) {
        if (preBegin > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preBegin]);
        //满足此条件说明这颗树只有这一个节点，直接返回就行了
        if (preBegin == preEnd) return root;
        int leftSize = preorderMap.get(postorder[postEnd - 1])
                - preBegin - 1;
        root.left = buildTree(preorder, preBegin + 1, preBegin + leftSize,
                postorder, postBegin, postBegin + leftSize - 1);
        root.right = buildTree(preorder, preBegin + leftSize + 1, preEnd,
                postorder, postBegin + leftSize, postEnd - 1);

        return root;
    }
}
