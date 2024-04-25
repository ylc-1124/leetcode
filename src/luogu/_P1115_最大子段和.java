package luogu;

import java.util.Scanner;

/**
 * @description: 最大子段和
 * @author: ylc
 * @date: 2023/12/13 10:44
 */
public class _P1115_最大子段和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        // 输入 n个元素
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 以 nums[i]为结尾的子段 的最大和为 dp[i]
        int[] dp = new int[n];
        // base case
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {  // O(n)
            dp[i] = Math.max(dp[i - 1] + nums[i], // 将 nums[i]加入最大和子串
                    nums[i]); // 不加入，以自己作为子段的首元素
        }

        // 找答案
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
