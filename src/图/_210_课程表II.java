package 图;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class _210_课程表II {
    //防止节点被重复遍历 visited[i]代表节点i被遍历了
    boolean[] visited;

    //为了判断访问过程中是否有环，我们添加下面两个成员变量
    //在一次递归下探的过程中，访问过的节点都做个标记
    boolean[] onPath;
    //判断是否有环
    boolean hasCycle;

    List<Integer> postorder = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        //每个节点都要遍历一遍才能确保图中所有节点都遍历了
        for (int i = 0; i < graph.length; i++) {
            dfs(graph, i);
        }
        //有环表示不能完成
        return !hasCycle;
    }

    /**
     * 从指定起点开始深度优先遍历图
     */
    private void dfs(List<Integer>[] graph, int start) {
        //如果当前节点在递归下探过程中已经遇到了，现在又遇到了，说明有环存在
        if (onPath[start]) {
            //有环
            hasCycle = true;
        }
        //base case
        //如果当前节点被遍历了，或者有环，直接返回
        if (visited[start] || hasCycle) return;

        //设置当前节点已访问
        visited[start] = true;
        onPath[start] = true;
        //递归下探此节点可以访问到的其他节点
        for (int next : graph[start]) {
            dfs(graph, next);
        }
        //回溯前还原现场
        onPath[start] = false;
        postorder.add(start);

    }

    /**
     * 建图--邻接表
     */
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        //初始化
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            //想修课程to，要先修课程from
            //将这条边信息加入图中
            graph[from].add(to);
        }
        return graph;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) {
            return new int[]{};
        }
        //后序遍历结果反一下就是拓扑排序结果
        Collections.reverse(postorder);
        int[] res = new int[postorder.size()];
        for (int i = 0; i < postorder.size(); i++) {
            res[i] = postorder.get(i);
        }

        return res;
    }


}
