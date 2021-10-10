package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class _剑指Offer07_重建二叉树 {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //将中序遍历数组，值和索引对应存入map中
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1
                , inorder, 0, inorder.length - 1);
    }

    /**
     * 按照前序遍历和后续遍历的数组建树
     *
     * @return 树的根节点
     */
    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd
            , int[] inorder, int inBegin, int inEnd) {
        if (preBegin > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preBegin]);
        //左子树的长度
        int leftSize = map.get(root.val) - inBegin;
        root.left = buildTree(preorder, preBegin + 1, preBegin + leftSize,
                inorder, inBegin, inBegin + leftSize - 1);
        root.right = buildTree(preorder, preBegin + leftSize + 1, preEnd,
                inorder, inBegin + leftSize + 1, inEnd);
        return root;
    }
}
