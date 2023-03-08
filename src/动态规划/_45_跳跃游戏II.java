package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class _45_跳跃游戏II {
    public int jump(int[] nums) {
        //memo[i]表示从i跳到最后一个位置需要的最少步数
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return dp(nums, 0, memo);
    }

    /**
     * 返回从索引为s作为起点往终点跳需要的最少步数
     */
    private int dp(int[] nums, int s, int[] memo) {
        if (s >= nums.length - 1) return 0;
        if (memo[s] != Integer.MAX_VALUE) return memo[s];
        //可选择的步数
        int step = nums[s];
        for (int i = 1; i <= step; i++) {
            memo[s] = Math.min(memo[s], dp(nums, s + i, memo) + 1);
        }
        return memo[s];
    }
}
