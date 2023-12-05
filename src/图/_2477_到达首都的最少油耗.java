package 图;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/5 21:21
 */
public class _2477_到达首都的最少油耗 {

    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        // 建图
        List<Integer>[] graph = new List[roads.length + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }

        // 访问标记
        boolean[] visited = new boolean[roads.length + 1];
        dfs(0, visited, graph, seats);
        return res;
    }

    private int dfs(int v, boolean[] visited, List<Integer>[] graph, int seats) {
        visited[v] = true;

        // 当前结点汇聚的人数
        int humans = 1;
        for (Integer adj : graph[v]) {
            if (!visited[adj]) {
                int sub = dfs(adj, visited, graph, seats);
                humans += sub;
            }
        }

        // 需要多少辆车
        if (v != 0) {
            int needCars = (int) Math.ceil((double) humans / seats);
            res += needCars;
        }

        return humans;
    }
}
