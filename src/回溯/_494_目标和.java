package 回溯;

/**
 * https://leetcode-cn.com/problems/target-sum/
 */
public class _494_目标和 {
    int res;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0) res++;
            return;
        }
        //做选择
        target += nums[i];
        backtrack(nums, i + 1, target);
        //撤销选择
        target -= nums[i];
        //做选择
        target -= nums[i];
        backtrack(nums, i + 1, target);
        //撤销选择
        target += nums[i];
    }
}
