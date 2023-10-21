package 每日一题;

import java.util.*;

public class _2316_统计无向图中无法互相到达点对数 {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            // 可以访问到的结点放在同一个连通分量
            uf.union(x, y);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int unvisited = n - uf.getSize(uf.find(i));
            res += unvisited;
        }
        // 假设0访问不到1，那么1也访问不到0，这两个无法访问的结点被记录了2次
        return res / 2;
    }

    static class UnionFind {
        int[] parents;
        int[] sizes;

        public UnionFind(int n) {
            parents = new int[n];
            // 初始化并查集
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            sizes = new int[n];
            Arrays.fill(sizes, 1);
        }

        public int find(int x) {
            // 找爹
            while (parents[x] != x) {
                x = parents[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            // 根结点不同才需要并
            if (rx != ry) {
                // 少的并入多的里面
                if (sizes[rx] > sizes[ry]) {
                    parents[ry] = rx;
                    sizes[rx] += sizes[ry];
                } else {
                    parents[rx] = ry;
                    sizes[ry] += sizes[rx];
                }
            }
        }

        public int getSize(int x) {
            return sizes[x];
        }
    }
}
