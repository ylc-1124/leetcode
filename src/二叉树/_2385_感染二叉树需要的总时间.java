package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ylc
 * @date: 2024/4/24 18:18
 */
public class _2385_感染二叉树需要的总时间 {

    private int maxDepth = 0;

    public int amountOfTime(TreeNode root, int start) {
        // 每个结点的值不同，因此可以把值作为结点的唯一标识
        // 先序遍历：将二叉树转无向图
        List<Integer>[] graph = new List[10_0001];
        buildGraph(root, null, graph);

        // 已start结点开始dfs，最深的就是答案
        boolean[] visited = new boolean[10_0001];
        Arrays.fill(visited, false);

        dfs(start, graph, 0,visited);
        return maxDepth - 1;
    }

    private void dfs(int i, List<Integer>[] graph, int depth, boolean[] visited) {
        visited[i] = true;
        depth++;
        maxDepth = Math.max(depth, maxDepth);

        for (Integer adj : graph[i]) {
            if (!visited[adj]) {
                dfs(adj, graph, depth, visited);
            }
        }
    }

    private void buildGraph(TreeNode node, TreeNode parent, List<Integer>[] graph) {
        if (node == null) return;
        List<Integer> adj = graph[node.val];
        if (adj == null) {
            adj= new ArrayList<>();
            graph[node.val] = adj;
        }

        // 建立与其父节点和子结点的联系
        if (parent != null) {
            adj.add(parent.val);
        }
        if (node.left != null) {
            adj.add(node.left.val);
        }
        if (node.right != null) {
            adj.add(node.right.val);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}
