package 二叉树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/print-binary-tree/
 */
public class _655_输出二叉树 {
    List<List<String>> ans = new LinkedList<>();

    public List<List<String>> printTree(TreeNode root) {
        //行数等于最大深度
        int rows = maxDepth(root);
        //列数等于2^maxDepth - 1
        int cols = (int) (Math.pow(2, rows) - 1);
        //初始化二维数组
        String[][] res = new String[rows][cols];
        for (String[] s : res) {
            Arrays.fill(s, "");
        }

        //左闭右开区间 [begin,end)
        dfs(root, 0, res, 0, cols);

        //二维数组转换成List<List<String>>
        for (String[] s : res) {
            List<String> list = new LinkedList<>();
            for (String str : s) {
                list.add(str);
            }
            ans.add(list);
        }
        return ans;
    }

    private void dfs(TreeNode root, int row
            , String[][] res, int begin, int end) {
        if (root == null) return;
        //找出指定范围的中点位置，放置节点的值
        int mid = (begin + end) >> 1;
        res[row][mid] = String.valueOf(root.val);
        dfs(root.left, row + 1, res, begin, mid);
        dfs(root.right, row + 1, res, mid + 1, end);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
