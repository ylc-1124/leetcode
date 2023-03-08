package 动态规划;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class _55_跳跃游戏 {
    public boolean canJump(int[] nums) {
        //最大能跳到的索引
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}
