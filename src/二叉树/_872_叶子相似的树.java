package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class _872_叶子相似的树 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        if (list1.size()!=list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i)!=list2.get(i)) return false;
        }
        return true;
    }

    private void dfs(TreeNode root,List<Integer> list) {
        if (root == null) return;
        dfs(root.left,list);
        dfs(root.right,list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
    }
}
