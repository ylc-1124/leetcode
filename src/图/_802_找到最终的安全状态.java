package 图;

import java.util.*;

/**
 * @description: 反向图 + 拓扑排序【找入度为 0的结点】
 * @author: ylc
 * @date: 2023/12/17 12:26
 */
public class _802_找到最终的安全状态 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;

        // 建立反图
        List<Integer>[] rg = new List[n];
        for (int i = 0; i < rg.length; i++) {
            rg[i] = new ArrayList<>();
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                rg[graph[i][j]].add(i);
            }
        }

        // 反图中进行拓扑排序
        int[] inDegree = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 原图的i的出度 = 反图i的入度
            inDegree[i] = graph[i].length;
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        // 保存入度为0的结点
        while (!stack.isEmpty()) {
            Integer safeNode = stack.pop();
            res.add(safeNode);
            // 维护入度
            for (Integer adj : rg[safeNode]) {
                if (--inDegree[adj] == 0) {
                    stack.push(adj);
                }
            }
        }

        res.sort((o1, o2) -> o1 - o2);
        return res;
    }

}
