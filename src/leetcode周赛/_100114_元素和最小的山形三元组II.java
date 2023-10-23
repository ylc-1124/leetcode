package leetcode周赛;

public class _100114_元素和最小的山形三元组II {
    public int minimumSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        int min_left = nums[0];

        // nums[i]右侧最小值为 min_right[i]
        int[] min_right = new int[nums.length];
        min_right[nums.length - 2] = nums[nums.length - 1];
        for (int i = nums.length - 3; i >= 0; i--) {
            min_right[i] = Math.min(min_right[i + 1], nums[i + 1]);
        }

        for (int j = 1; j < nums.length - 1; j++) {
            int i = j - 1, k = j + 1;
            min_left = Math.min(min_left, nums[j - 1]);
            if (min_left >= nums[j] || min_right[j] >= nums[j]) continue;
            min = Math.min(nums[j] + min_left + min_right[j], min);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
