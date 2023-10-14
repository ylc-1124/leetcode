package 每日一题;

import java.util.Arrays;

public class _2731_移动机器人 {
    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length; // 机器人个数
        char[] cs = s.toCharArray();
        for (int i = 0; i < d; i++) {
            // 更新当前机器人的位置
            for (int j = 0; j < n; j++) {
                if (cs[j] == 'R') {
                    nums[j] += 1;
                } else {
                    nums[j] -= 1;
                }
            }
            // 更新下一秒的移动方向
            for (int j = 0; j < n - 1; j++) {
                if (nums[j] == nums[j + 1]) {
                    cs[j] = cs[j] == 'R' ? 'L' : 'R';
                    cs[j + 1] = cs[j + 1] == 'R' ? 'L' : 'R';
                }
            }

        }
        // 计算任意两个机器人之间的距离
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res += Math.abs(nums[i] - nums[j]);
            }
        }

        return (int) (res % (Math.pow(10, 9) + 7));
    }

}
