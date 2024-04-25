package 图;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/path-with-minimum-effort/
 */
public class _1631_最小体力消耗路径 {
    int res = Integer.MAX_VALUE;

    // 严重超时。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        if (rows == columns && rows == 1) return 0;
        int vertices = rows * columns;

        // 每个结点的cost
        int[] cost = new int[vertices];
        int idx = 0;
        // 保存一维到二维的映射
        Map<Integer, State> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map.put(idx, new State(i, j));
                cost[idx++] = heights[i][j];
            }
        }

        // 建图
        List<Integer>[] graph = new List[vertices];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < vertices; i++) {
            // 上
            int upNode = i - columns;
            // 下
            int downNode = i + columns;
            // 左
            int leftNode = i - 1;
            // 右
            int rightNode = i + 1;
            checkAndSet(i, map, graph, rows, columns, upNode, downNode, leftNode, rightNode);
        }

        // 遍历
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, vertices - 1, graph, path, cost);

        return res;
    }

    private void checkAndSet(int node, Map<Integer, State> map, List<Integer>[] graph, int rows, int columns,
                             int upNode, int downNode, int leftNode, int rightNode) {

        State state = map.get(node);
        if (state.row != 0) {
            graph[node].add(upNode);
        }
        if (state.row != rows - 1) {
            graph[node].add(downNode);
        }
        if (state.column != 0) {
            graph[node].add(leftNode);
        }
        if (state.column != columns - 1) {
            graph[node].add(rightNode);
        }
    }

    class State {
        int row;
        int column;

        public State(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }


    private void dfs(int v, int end, List<Integer>[] graph, List<Integer> path, int[] cost) {
        if (v == end) {
            int max = Integer.MIN_VALUE;
            // 求路径上两两结点差的绝对值 的最大值
            for (int i = 0; i < path.size() - 1; i++) {
                int abs = Math.abs(cost[path.get(i)] - cost[path.get(i + 1)]);
                max = Math.max(max, abs);
            }
            res = Math.min(res, max);
            return;
        }

        for (Integer adj : graph[v]) {
            if (!path.contains(adj)) {
                // 做选择
                path.add(adj);
                dfs(adj, end, graph, path, cost);
                // 还原现场
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1631_最小体力消耗路径().minimumEffortPath(new int[][]{{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}}));
    }


//    // Dijkstra 算法，计算 (0, 0) 到 (m - 1, n - 1) 的最小体力消耗
//    int minimumEffortPath(int[][] heights) {
//        int m = heights.length, n = heights[0].length;
//        // 定义：从 (0, 0) 到 (i, j) 的最小体力消耗是 effortTo[i][j]
//        int[][] effortTo = new int[m][n];
//        // dp table 初始化为正无穷
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
//        }
//        // base case，起点到起点的最小消耗就是 0
//        effortTo[0][0] = 0;
//
//        // 优先级队列，effortFromStart 较小的排在前面
//        Queue<State> pq = new PriorityQueue<>((a, b) -> {
//            return a.effortFromStart - b.effortFromStart;
//        });
//
//        // 从起点 (0, 0) 开始进行 BFS
//        pq.offer(new State(0, 0, 0));
//
//        while (!pq.isEmpty()) {
//            State curState = pq.poll();
//            int curX = curState.x;
//            int curY = curState.y;
//            int curEffortFromStart = curState.effortFromStart;
//
//            // 到达终点提前结束
//            if (curX == m - 1 && curY == n - 1) {
//                return curEffortFromStart;
//            }
//
//            if (curEffortFromStart > effortTo[curX][curY]) {
//                continue;
//            }
//            // 将 (curX, curY) 的相邻坐标装入队列
//            for (int[] neighbor : adj(heights, curX, curY)) {
//                int nextX = neighbor[0];
//                int nextY = neighbor[1];
//                // 计算从 (curX, curY) 达到 (nextX, nextY) 的消耗
//                int effortToNextNode = Math.max(
//                        effortTo[curX][curY],
//                        Math.abs(heights[curX][curY] - heights[nextX][nextY])
//                );
//                // 更新 dp table
//                if (effortTo[nextX][nextY] > effortToNextNode) {
//                    effortTo[nextX][nextY] = effortToNextNode;
//                    pq.offer(new State(nextX, nextY, effortToNextNode));
//                }
//            }
//        }
//        // 正常情况不会达到这个 return
//        return -1;
//    }
//
//    /**
//     * 求出(x,y)节点的相邻节点
//     */
//    List<int[]> adj(int[][] matrix, int x, int y) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        List<int[]> neighbors = new LinkedList<>();
//        //方向数组，存放上下左右四个方向，用来计算邻居的坐标
//        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//        for (int[] dir : dirs) {
//            int nx = x + dir[0];
//            int ny = y + dir[1];
//            //索引越界表示不存在此节点
//            if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
//            neighbors.add(new int[]{nx, ny});
//        }
//        return neighbors;
//    }
//
//    /**
//     * 这个类用来保存挑选节点需要的相关信息
//     */
//    class State {
//        int x, y;
//        int effortFromStart;
//
//        public State(int x, int y, int effortFromStart) {
//            this.x = x;
//            this.y = y;
//            this.effortFromStart = effortFromStart;
//        }
//    }
}
