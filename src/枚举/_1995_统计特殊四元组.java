package 枚举;

/**
 * https://leetcode.cn/problems/count-special-quadruplets/
 */
public class _1995_统计特殊四元组 {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int a = 0; a < nums.length; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                for (int c = b + 1; c < nums.length; c++) {
                    for (int d = c + 1; d < nums.length; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
