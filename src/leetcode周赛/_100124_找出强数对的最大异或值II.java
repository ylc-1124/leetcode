package leetcode周赛;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/12 11:46
 */
public class _100124_找出强数对的最大异或值II {
    public int maximumStrongPairXor(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    max = Math.max(max, nums[i] ^ nums[j]);
                }
            }
        }

        return max;
    }
}
