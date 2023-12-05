package SaikrOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/3 12:50
 */
public class _有星星就表白 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int vertices = sc.nextInt();
            int edges = sc.nextInt();

            // 建图
            List<Integer>[] graph = new List[vertices + 1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[x].add(y);
                graph[y].add(x);
            }

            if (edges != vertices - 1) {
                System.out.println("No");
                continue;
            }

            int[] degree = new int[vertices + 1];
            for (int i = 1; i <= vertices; i++) {
                degree[i] = graph[i].size();
            }
            int num = 0;
            for (int i = 1; i <= vertices; i++) {
                if (degree[i] > 2) {
                    num++;
                }
            }
            if (num >= 2) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }
    }
}
