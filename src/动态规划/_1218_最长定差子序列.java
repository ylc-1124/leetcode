package 动态规划;

import java.util.HashMap;
import java.util.Map;

public class _1218_最长定差子序列 {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        // 以 arr[i]为结尾的定差子序列的最大长度为 dp[i]
        int[] dp = new int[n];
        // 快速找到某个子问题的答案
        Map<Integer, Integer> map = new HashMap<>();
        // base case
        dp[0] = 1;
        map.put(arr[0], dp[0]);

        for (int i = 1; i < n; i++) {
            // 只需要找 arr[j] == arr[i] - diff 这个子问题的解（遍历前面所有状态找会超时 ==> 用map记录）
            dp[i] = map.getOrDefault(arr[i] - difference, 0) + 1;
            map.put(arr[i], dp[i]);
        }

        // 找答案
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
