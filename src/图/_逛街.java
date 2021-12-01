package 图;

import java.util.*;

public class _逛街 {
    static int[] costs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n个节点 编号 1~n
        int m = sc.nextInt(); //m条边
        int[][] edges = new int[m][4];
        for (int[] edge : edges) {
            edge[0] = sc.nextInt();
            edge[1] = sc.nextInt();
            edge[2] = sc.nextInt();
            edge[3] = sc.nextInt();
        }
        int s= sc.nextInt(); //起点
        int t= sc.nextInt(); //终点

        //建图
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int dist = edge[2];
            int cost = edge[3];
            graph[from].add(new int[]{to, dist, cost});
        }
        //存放源点到每个节点的花费情况
        costs = new int[n + 1];
        //dijkstra算法求出单源最短路径，并且维护好了costs数组
        int[] distTo = dijkstra(s, graph);

        //打印结果
        System.out.println(distTo[t]+" "+costs[t]);
    }

    private static int[] dijkstra(int start, List<int[]>[] graph) {
        //维护源点到所以节点的最短路径，distTo[1]表示了源点到节点1的最短路径值
        int[] distTo = new int[graph.length];
        //初始化所有节点最短路径都为无穷大
        Arrays.fill(distTo, Integer.MAX_VALUE);
        Arrays.fill(costs, Integer.MAX_VALUE);
        //base case 源点最短路径是0
        distTo[start] = 0;
        costs[start] = 0;

        Queue<State> queue = new PriorityQueue<>((o1, o2) -> {
                    if (o1.distFromStart == o2.distFromStart) return o1.costFromStart - o2.costFromStart;
                    return o1.distFromStart - o2.distFromStart;
                });
        queue.offer(new State(start, 0, 0));
        //BFS
        while (!queue.isEmpty()) {
            State curNodeState = queue.poll();
            int curNode = curNodeState.id;
            int distToCurNode = curNodeState.distFromStart;
            if (distToCurNode > distTo[curNode]) continue;

            for (int[] neighbour : graph[curNode]) {
                int nextNode = neighbour[0];
                int distToNextNode = distTo[curNode] + neighbour[1];
                int costToNextNode = costs[curNode] + neighbour[2];
                if (distTo[nextNode] > distToNextNode) {
                    //松弛成功
                    distTo[nextNode] = distToNextNode;
                    costs[nextNode] = costToNextNode;
                    queue.offer(new State(nextNode, distToNextNode,costToNextNode));
                }
            }

        }
        return distTo;
    }


    private static class State {
        int id; //代表一个节点
        int distFromStart; //从源点到当前节点的距离
        int costFromStart; //从源点到当前节点的花费

        public State(int id, int distFromStart,int costFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
            this.costFromStart = costFromStart;
        }
    }
}
