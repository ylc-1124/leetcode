package leetcode周赛;

public class _100106_元素和最小的山形三元组I {
    public int minimumSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        min = Math.min(nums[i] + nums[j] + nums[k], min);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
