package 图;

import java.util.*;

/**
 * sustoj
 */
public class _砍渣渣辉 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n个节点 编号1~n
        int m = sc.nextInt(); //m行边信息
        int k = sc.nextInt(); //k个粉丝
        int s = sc.nextInt(); //s是渣渣辉的位置
        //我们将问题转换为求源点s到粉丝的位置的最短路径，需要反向建图
        //初始化数据
        int[][] edges = new int[m][3];
        for (int[] edge : edges) {
            edge[0] = sc.nextInt(); //终点
            edge[1] = sc.nextInt(); //起点
            edge[2] = sc.nextInt(); //权值
        }
        //粉丝所在节点
        int[] fans = new int[k];
        for (int i = 0; i < fans.length; i++) {
            fans[i]= sc.nextInt();
        }

        //邻接表存储图结构
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        //初始化图中数据
        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }
        //使用dijkstra算法求出s为源点的单源最短路径
        int[] distTo = dijkstra(s, graph);
        //打印结果
        for (int i = 0; i < fans.length; i++) {
            System.out.println(distTo[fans[i]]);
        }

    }

    private static int[] dijkstra(int start, List<int[]>[] graph) {
        //维护源点到所以节点的最短路径，distTo[1]表示了源点到节点1的最短路径值
        int[] distTo = new int[graph.length];
        //初始化所有节点最短路径都为无穷大
        Arrays.fill(distTo, Integer.MAX_VALUE);
        //base case 源点最短路径是0
        distTo[start] = 0;
        Queue<State> queue =
                new PriorityQueue<>((o1, o2) -> o1.distFromStart - o2.distFromStart);
        queue.offer(new State(start, 0));
        //BFS
        while (!queue.isEmpty()) {
            State curNodeState = queue.poll();
            int curNode = curNodeState.id;
            int distToCurNode = curNodeState.distFromStart;
            if (distToCurNode > distTo[curNode]) continue;

            for (int[] neighbour : graph[curNode]) {
                int nextNode = neighbour[0];
                int distToNextNode = distTo[curNode] + neighbour[1];
                if (distTo[nextNode] > distToNextNode) {
                    distTo[nextNode] = distToNextNode;
                    queue.offer(new State(nextNode, distToNextNode));
                }
            }

        }
        return distTo;
    }

    /**
     * 保存了图中节点id和到源点的距离
     */
    private static class State {
        int id;
        int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

}
