package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/
 */
public class _508_出现次数最多的子树元素和 {
    int max;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> res = new LinkedList<>();
        for (Integer val : map.keySet()) {
            if (map.get(val) == max) {
                res.add(val);
            }
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;

    }


    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int val = left + right + root.val;
        Integer freq = map.getOrDefault(val, 0);
        map.put(val, ++freq);
        max = Math.max(max, freq);
        return val;
    }

}
