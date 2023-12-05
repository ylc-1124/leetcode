package 并查集;

/**
 * QuickUnion 基于size+路径压缩优化
 */
public class UF {
    //连通分量个数
    private int count;
    //存储一棵 树
    public int[] parent;
    //记录每棵树的子节点数
    private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 将节点p和节点q连通
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        //节点少的树嫁接到节点多的树（整颗树）
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        //两个连通分量合并成一个连通分量
        count--;
    }

    /**
     * 判断节点p和节点q是否连通
     */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * 返回节点x的连通分量的根节点
     */
    public int find(int x) {
        while (parent[x] != x) {
            //路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    /**
     * 返回图中连通分量个数
     */
    public int count() {
        return count;
    }
}
