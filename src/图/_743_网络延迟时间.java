package 图;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/network-delay-time/
 */
public class _743_网络延迟时间 {
    /**
     * 思路：权值是传播时间，通过dijkstra算法求出最短路径后，其中最大值就是答案
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        //维护一张图结构，（题目将节点标记为 1-n 所以这里空间申请 n+1）
        List<int[]>[] graph = new List[n + 1];
        //图的初始化
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }
        //使用Dijkstra算法求出最短路径
        int[] distTo = dijkstra(k, graph);
        int res = 0;
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, distTo[i]);
        }

        return res;
    }

    private int[] dijkstra(int start, List<int[]>[] graph) {
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
    class State {
        int id;
        int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    /*
    public int networkDelayTime(int[][] times, int n, int k) {
        //建图，节点编号从1到n
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            //邻接表存储图结果，并且保存权值信息
            graph[from].add(new int[]{to, weight});
        }
        //通过dijkstra算法，得出k到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);
        //找出路径距离最长的
        int res = 0;
        //0索引没用
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    private int[] dijkstra(int start, List<int[]>[] graph) {
        //维护start到各个节点的最短路径
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        //base case 源点到源点的距离为0
        distTo[start] = 0;
        //优先级队列选择距离最短的出队
        //存放候选节点（成为候选节点的规则：至少知道一条从源点通往该节点的路径）
        //一开始里面只有源点，因为只知道源点到源点距离是0
        PriorityQueue<State> heap =
                new PriorityQueue<>((o1, o2) -> o1.distFromStart - o2.distFromStart);
        heap.offer(new State(start, 0));

        //BFS
        while (!heap.isEmpty()) {
            //弹出的当前节点最短路径就确定了
            State cur = heap.poll();
            int curNodeId = cur.id;
            int curDistFromStart = cur.distFromStart;
            //已有更短的路径
            if (curDistFromStart > distTo[curNodeId]) continue;
            //松弛当前节点的邻边
            for (int[] neighbor : graph[curNodeId]) {
                int nextNodeID = neighbor[0];
                //新的权值
                int distToNextNode = distTo[curNodeId] + neighbor[1];
                //看看通过curNode到达nextNode会不会更短
                //如果比distTo之前维护的路径短，则替换，松弛成功
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    heap.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }

    class State {
        //节点的id
        int id;
        //节点距离源点的距离
        int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
*/
}
