package 每日一题;

import java.util.*;

public class _2003_每棵子树内缺失的最小基因值 {
    public int[] smallestMissingValueSubtree(int[] parents,
                                             int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // 只有基因值为 1的结点及其祖先结点的 ans[i]才不为 1，需要我们计算
        Arrays.fill(ans, 1);

        // 建树（方便遍历）
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < parents.length; i++) {
            // 获取当前结点的父节点的孩子列表
            List<Integer> children = map.get(parents[i]);
            if (children != null) {
                children.add(i);
            } else {
                List<Integer> ch = new ArrayList<>();
                ch.add(i);
                map.put(parents[i], ch);
            }
        }

        // 找到基因值为 1的结点
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                node = i;
                break;
            }
        }
        // 没有基因值为 1 的直接结束了
        if (node == -1) {
            return ans;
        }

        Set<Integer> set = new HashSet<>();
        int min_gene = 2; // 最小可能的基因值

        // 遍历基因为 1 的祖先节点
        while (node >= 0) {
            dfs(node, map, nums, set);
            while (set.contains(min_gene)) {
                // 祖先节点的最小缺失基因值只可能 >= 其子树
                min_gene++;
            }
            ans[node] = min_gene;
            node = parents[node];
        }

        return ans;
    }

    /**
     * 往 set中添加子树包含的基因值
     */
    private void dfs(int node, Map<Integer, List<Integer>> map,
                     int[] nums, Set<Integer> set) {
        // 如果 set中包含了该结点的基因值说明遍历过该子树了
        if (set.contains(nums[node])) return;
        // 添加基因值
        set.add(nums[node]);

        List<Integer> children = map.get(node);
        if (children != null) {
            for (Integer child : children) {
                dfs(child, map, nums, set);
            }
        }
    }


}
