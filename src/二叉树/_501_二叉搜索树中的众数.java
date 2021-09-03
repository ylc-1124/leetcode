package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class _501_二叉搜索树中的众数 {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        Set<Map.Entry<Integer, Integer>> nodes = map.entrySet();
        Map.Entry<Integer, Integer>[] entries = nodes.toArray(new Map.Entry[nodes.size()]);
        Arrays.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> list = new LinkedList<>();
        list.add(entries[0].getKey());
        for (int i = 1; i < entries.length; i++) {
            if (entries[i].getValue()!=entries[0].getValue()) break;
            list.add(entries[i].getKey());
        }
        // list转成数组
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        dfs(root.left, map);
        Integer freq = map.getOrDefault(root.val, 0);
        map.put(root.val, ++freq);
        dfs(root.right, map);
    }
}
