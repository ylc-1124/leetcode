package luogu;

import java.util.*;

/**
 * @description: Prim实现 MST （超内存）
 * @author: ylc
 * @date: 2023/11/13 17:17
 */
public class _P3366_模板_最小生成树Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // N个顶点的无向图邻接表
        List<AdjNode>[] graph = new List[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 建无向图
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();

            graph[x].add(new AdjNode(y, cost));
            graph[y].add(new AdjNode(x, cost));
        }

        int res = 0;

        // Prim 将顶点分成两个集合：{加入最小生成树的顶点}  {未加入最小生成树的顶点}
        Set<Integer> set = new HashSet<>(); // 最小生成树种包含的结点
        set.add(1); // 从任意结点开始均可

        while (set.size() < N) {
            int min_node = -1, min_cost = Integer.MAX_VALUE;
            for (Integer node : set) {
                for (AdjNode adjNode : graph[node]) {
                    if (set.contains(adjNode.vertex)) continue;

                    if (adjNode.cost < min_cost) {
                        min_cost = adjNode.cost;
                        min_node = adjNode.vertex;
                    }
                }
            }


            if (min_node != -1) {
                set.add(min_node);
                res += min_cost;
            } else {
                // 如果未加入任何结点，说明无法构成最小生成树
                System.out.println("orz");
                return;
            }
        }

        System.out.println(res);

    }
    static class AdjNode {
        int vertex;
        int cost;

        public AdjNode(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
