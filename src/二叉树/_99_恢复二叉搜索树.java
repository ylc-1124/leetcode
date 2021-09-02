package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */
public class _99_恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        inorder(root, list);
        swap(list);
    }
    private void swap(List<TreeNode> list) {
        TreeNode tmp1 = null;
        TreeNode tmp2 = null;
        //遍历查找两个位置不正确的结点
        for (int i = 0; i < list.size() - 1; i++) {
            //如果当前结点的值 大于后面一个结点（这样的结点最多有两个）
            if (list.get(i).val > list.get(i + 1).val) {
                tmp2 = list.get(i + 1);
                if (tmp1 == null) {
                    tmp1 = list.get(i);
                }
            }
        }
        if (tmp1 != null && tmp2 != null) {
            int tmp = tmp1.val;
            tmp1.val = tmp2.val;
            tmp2.val = tmp;
        }

    }

    private void inorder(TreeNode root,List<TreeNode> list) {
        if (root == null) return;

        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}
