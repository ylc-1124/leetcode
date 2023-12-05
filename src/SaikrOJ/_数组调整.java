package SaikrOJ;

import java.util.Scanner;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/2 19:01
 */
public class _数组调整 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        nums[k - 1] = -nums[k - 1];
        for (int i = 0; i < n; i++) {
            res += nums[i];
        }
        System.out.println(res);
    }
}
