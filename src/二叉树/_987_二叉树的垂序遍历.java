package 二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class _987_二叉树的垂序遍历 {
    List<List<Integer>> res = new LinkedList<>();
    Map<Integer, List<TreeInfo>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        //先进行排序，再把列号保存到cols中
        List<Integer> cols = new LinkedList<>();
        for (Integer col : map.keySet()) {
            map.get(col).sort((o1, o2) -> {
                if (o1.row != o2.row) return o1.row - o2.row;
                else return o1.val - o2.val;
            });
            cols.add(col);
        }
        cols.sort((o1, o2) -> o1 - o2); //列号排序

        for (Integer col : cols) {
            //把 map映射的有用的节点值取出来放到新列表中
            List<Integer> vals = new LinkedList<>();
            for (TreeInfo info : map.get(col)) {
                vals.add(info.val);
            }
            res.add(vals);
        }
        return res;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
        if (map.containsKey(col)) {
            List<TreeInfo> list = map.get(col);
            list.add(new TreeInfo(root.val, row));

        } else {
            List<TreeInfo> list = new LinkedList<>();
            list.add(new TreeInfo(root.val, row));
            map.put(col, list);
        }
    }

    private class TreeInfo {
        int val;
        int row;
        public TreeInfo(int val, int row) {
            this.val = val;
            this.row = row;
        }
    }

}
