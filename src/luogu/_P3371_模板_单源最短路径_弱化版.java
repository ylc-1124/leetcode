package luogu;

import java.util.*;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/15 11:52
 */
public class _P3371_模板_单源最短路径_弱化版 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_vertices = sc.nextInt();
        int num_edges = sc.nextInt();
        int start = sc.nextInt();

        // 建有向图（无结点 0）
        List<AdjNode>[] graph = new List[num_vertices + 1];
        for (int i = 1; i <= num_vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < num_edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[from].add(new AdjNode(to, cost));
        }

        int[] dist = dijstra(start, graph);
        for (int i = 1; i <= num_vertices; i++) {
            System.out.print(dist[i] + " ");
        }

    }

    private static int[] dijstra(int start, List<AdjNode>[] graph) {
        // 源点 start到 结点 i的最短路径为 dist[i]
        int[] dist = new int[graph.length];
        // 小根堆
        Queue<State> heap = new PriorityQueue<>((o1, o2) -> o1.distFromStart - o2.distFromStart);

        // 初始化
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        heap.add(new State(start, 0));

        while (!heap.isEmpty()) {
            State curState = heap.poll();
            int curNode = curState.node;
            int curDistFromStart = curState.distFromStart;

            // 已经有一条更短的路径到达 curNode结点了
            if (curDistFromStart > dist[curNode]) continue;

            // 松弛操作
            for (AdjNode adjNode : graph[curNode]) {
                int newDist = dist[curNode] + adjNode.cost;
                if (dist[adjNode.node] > newDist) {
                    dist[adjNode.node] = newDist;

                    heap.add(new State(adjNode.node, newDist));
                }

            }
        }



        return dist;
    }

    static class State {
        int node;
        int distFromStart;

        public State(int node, int distFromStart) {
            this.node = node;
            this.distFromStart = distFromStart;
        }
    }

    static class AdjNode {
        int node;
        int cost;

        public AdjNode(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
