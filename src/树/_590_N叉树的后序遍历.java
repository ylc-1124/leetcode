package 树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(Node root, List<Integer> list) {
        // base case
        if (root == null) return;
        //递归遍历子树
        for (Node child : root.children) {
            dfs(child, list);
        }
        //后序遍历代码位置
        list.add(root.val);

    }
}
