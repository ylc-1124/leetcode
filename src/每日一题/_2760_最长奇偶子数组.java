package 每日一题;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/16 20:50
 */
public class _2760_最长奇偶子数组 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        for (int l = 0; l < nums.length; l++) {
            if (nums[l] % 2 != 0 || nums[l] > threshold) continue;

            int len = 1;
            for (int r = l + 1; r < nums.length; r++) {
                if (nums[r] > threshold) break;

                if (nums[r] % 2 != nums[r - 1] % 2) {
                    len++;
                } else {
                    break;
                }
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
