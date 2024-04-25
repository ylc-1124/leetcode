package 图;

import 并查集.UF;

/**
 * @description: 计算图的连通分量
 * @author: ylc
 * @date: 2023/12/17 12:04
 */
public class _547_省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;  // 结点个数
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
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

}
