package 并查集;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/12 10:14
 */
public class Test {
    public static void main(String[] args) {
        UF uf = new UF(5);
        uf.union(0, 1);
        uf.union(0, 2);
        uf.union(1, 3);
        uf.union(2, 3);
        // 找同一个连通域
        System.out.println("与v0同一个连通域的有");
        int root = uf.find(0);
        for (int i = 0; i < uf.parent.length; i++) {
            if (uf.parent[i] == root) {
                System.out.println(i);
            }
        }
    }
}
