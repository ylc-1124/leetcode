package SaikrOJ;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/3 9:29
 */
public class _数组查询 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 测试用例数
        while (n-- > 0) {
            int size = sc.nextInt(); // 数组大小
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            // 全局大根堆
            Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

            // 进行查询 size个查询
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                heap.add(arr[i]);

                // 每轮循环使用的大根堆
                Queue<Integer> heap_local = new PriorityQueue<>(heap);

                boolean flag = false; // 是否输出结果
                while (!heap_local.isEmpty()) {
                    Integer v = heap_local.poll();
                    if (v <= x) {
                        System.out.println(v);
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    System.out.println(-1);
                }
            }
        }
    }
}
