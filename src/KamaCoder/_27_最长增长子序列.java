package KamaCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _27_最长增长子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] nums = s.substring(1, s.length() - 1).split(",");
            List<Integer> list = new ArrayList<>();
            for (String num : nums) {
                list.add(Integer.parseInt(num));
            }
            lists.add(list);
        }
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            int n = list.size();
            // 以 list[i]为结尾的递增子序列的最大长度为 dp[i]
            int[] dp = new int[n];
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                boolean hasSub = false;
                for (int k = 0; k < j; k++) {
                    if (list.get(k) < list.get(j)) {
                        dp[j] = Math.max(dp[k] + 1, dp[j]);
                        hasSub = true;
                    }
                }
                if (!hasSub) {
                    dp[j] = 1;
                }
            }
            // 打印答案
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < dp.length; j++) {
                max = Math.max(dp[j], max);
            }
            System.out.println(max);
        }
    }
}
