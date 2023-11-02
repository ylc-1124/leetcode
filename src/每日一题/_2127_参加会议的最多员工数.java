package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _2127_参加会议的最多员工数 {
    public int maximumInvitations(int[] favorite) {

        int n = favorite.length;

        // 初始化反图（这里构造出的其实是棵树）
        List<Integer>[] rg = new List[n];
        for (int i = 0; i < rg.length; i++) {
            rg[i] = new ArrayList<>();
        }

        // 存放 n个顶点的入度
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            inDegree[favorite[i]]++;
        }
        Stack<Integer> stack = new Stack<>();
        // 入度为零的顶点入栈
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            int adjNode = favorite[node];
            // 构建反图
            rg[adjNode].add(node);
            if (--inDegree[adjNode] == 0) {
                stack.push(adjNode);
            }
        }

        // 可能存在多个基环
        int maxRingSize = 0, sumChainSize = 0;
        // 遍历每个基环
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) continue;
            inDegree[i] = 0;  // 标记当前基环顶点已访问
            int ringSize = 1;
            // 从它下一个顶点开始遍历（类似循环单链表）
            int node = favorite[i];
            while (node != i) {
                ringSize++;
                inDegree[node] = 0;
                node = favorite[node];
            }

            if (ringSize == 2) { // 基环长度为 2的情况，每个基环不影响，所以是累计求和
                sumChainSize += dfs(i, rg) + dfs(favorite[i], rg);
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }

        }

        return Math.max(maxRingSize, sumChainSize);
    }

    /**
     * 返回以 node为起点的树的最大深度
     */
    private int dfs(int node, List<Integer>[] rg) {
        if (rg[node].isEmpty()) return 1;

        int maxDepth = Integer.MIN_VALUE;
        for (Integer child : rg[node]) {
            maxDepth = Math.max(dfs(child, rg) + 1, maxDepth);
        }
        return maxDepth;
    }

}
