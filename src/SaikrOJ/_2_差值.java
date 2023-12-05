package SaikrOJ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/26 15:45
 */
public class _2_差值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            int v = Math.abs(arr[i] - arr[i - 1]);
            res = Math.min(res, v);
        }
        System.out.println(res);
    }
}
