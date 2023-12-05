package luogu;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/13 16:52
 */
public class _P3367_模板_并查集 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < M; i++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (op == 1) {
                uf.union(x - 1, y - 1);
            } else if (op == 2) {
                int rx = uf.find(x - 1);
                int ry = uf.find(y - 1);
                if (rx == ry) {
                    System.out.println("Y");
                } else {
                    System.out.println("N");
                }
            }
        }
    }

    static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
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
            }
        }
    }
}
