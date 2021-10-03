package 二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class _1457_二叉树中的伪回文路径 {
    //freq数组的索引与root.val对应
    int[] freq = new int[10];
    int res;
    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        freq[root.val]++;
        dfs(root.left);
        dfs(root.right);
        if (root.left == null && root.right == null) {
            int count = 0; //记录节点值出现奇数次的个数
            for (int i : freq) {
                if (i % 2 != 0) count++;
            }
            if (count < 2) res++;
        }
        //还原现场
        freq[root.val]--;
    }
}
