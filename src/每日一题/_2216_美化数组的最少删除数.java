package 每日一题;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/21 20:22
 */
public class _2216_美化数组的最少删除数 {
    public int minDeletion(int[] nums) {
        int count = 0;
        int n = nums.length;
        int new_idx = 0;
        for (int i = 0; i < n - 1; i++) {
            if (new_idx % 2 == 0 && nums[i] == nums[i + 1]) {
                count++;
            } else {
                new_idx++;
            }
        }
        if (new_idx % 2 == 0) {
            count++;
        }

        return count;
    }
}
