package 图;

import java.util.*;

/**
 * sustoj
 */
public class _N个比赛队伍排名 {
    //防止节点被重复遍历
    static boolean[] visited;
    static List<Integer> res = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n个队伍 编号1~n
        int m = sc.nextInt(); // m行可以形成边的数据
        //初始化
        int[][] edges = new int[m][2];
        for (int[] edge : edges) {
            edge[0] = sc.nextInt(); //起点
            edge[1] = sc.nextInt(); //终点
        }
        //邻接表保存图信息
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        //初始化图中数据
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }

        //深度优先遍历图
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dfs(graph, i);
        }
        //后序遍历结果翻转后才是拓扑排序结果
        Collections.reverse(res);

        //打印拓扑排序结果
        for (int v : res) {
            System.out.print(v+" ");
        }
    }

    /**
     * 从start开始深度优先遍历图
     */
    private static void dfs(List<Integer>[] graph, int start) {
        if (visited[start]) return;
        //递归前标记节点已访问
        visited[start] = true;
        for (int next : graph[start]) {
            dfs(graph, next);
        }
        //回溯前添加节点到结果集
        res.add(start);
    }
}
