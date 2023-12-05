package luogu;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/13 17:07
 */
public class _P1111_修复公路 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        // 小根堆保存边
        Queue<Edge> heap = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            heap.add(new Edge(v1, v2, cost));
        }

        UnionFind uf = new UnionFind(N);
        int max_cost = Integer.MIN_VALUE;
        // Kruskal
        while (uf.count > 1 && !heap.isEmpty()) {
            Edge edge = heap.poll();
            int v1 = edge.v1, v2 = edge.v2;
            if (uf.find(v1) != uf.find(v2)) {
                uf.union(v1, v2);

                max_cost = Math.max(max_cost, edge.cost);
            }
        }

        if (uf.count > 1) {
            System.out.println(-1);
        } else {
            System.out.println(max_cost);
        }

    }
    static class UnionFind{
        int[] parent;
        int[] size;
        int count; // 连通分量个数

        public UnionFind(int n) {
            // 结点号 1 ~ n
            parent = new int[n + 1];
            size = new int[n + 1];
            count = n;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                x = parent[parent[x]];
            }
            return x;
        }

        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx != ry) {
                if (size[rx] < size[ry]) {
                    parent[rx] = ry;
                    size[ry] += size[rx];
                } else {
                    parent[ry] = rx;
                    size[rx] += size[ry];
                }
                count--;
            }
        }

    }

    static class Edge {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }
}
