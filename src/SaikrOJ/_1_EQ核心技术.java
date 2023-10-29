package SaikrOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _1_EQ核心技术 {

    public static int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[] loudness = new int[arr.length];
        for (int i = 0; i < loudness.length; i++) {
            loudness[i] = arr[i][1];
        }

        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                // 调整 [start...end] 的响度
                int max = Integer.MIN_VALUE;
                for (int i = start; i <= end; i++) {
                    max = Math.max(loudness[i], max);
                }
                // 做选择
                for (int i = start; i <= end; i++) {
                    loudness[i] -= max;
                }
                // 计算结果并比较
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < loudness.length; i++) {
                    min = Math.min(loudness[i], min);
                }
                res = Math.max(min, res);
                // 还原现场
                for (int i = start; i <= end; i++) {
                    loudness[i] += max;
                }
            }
        }
        System.out.println(res);
    }

}
