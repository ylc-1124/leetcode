package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

public class _646_最长数对链 {
    public int findLongestChain(int[][] pairs) {
        // 排序后，可能接在 pairs[i]的数对 只可能在他前面（类似于最长递增子序列）
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        int n = pairs.length;
        // 以 pairs[i]作为数对链尾的 最长数对链的长度为 dp[i]
        int[] dp = new int[n];
        // base case
        dp[0] = 1;

        for (int i = 1; i < n; i++) { // 枚举状态
            boolean hasSub = false;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    hasSub = true;
                }
            }
            // 如果没有子问题，那么解就是 1
            if (!hasSub) {
                dp[i] = 1;
            }
        }

        // 找答案
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
