package 动态规划;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class _198_打家劫舍 {
    public int rob(int[] nums) {
        int n = nums.length; // 房屋数量
        // 对于前i户人家，最多能偷到dp[i]块钱
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }

//    int[] memo;
//    public int rob(int[] nums) {
//        //备忘录--记录偷到每一家时，能偷到最多钱的数量
//        memo = new int[nums.length];
//        Arrays.fill(memo, -666);
//
//        //偷完所有住户所得到的结果就是要求的结果
//        return dp(nums, nums.length - 1);
//    }
//
//    /**
//     * 偷盗当前住户时，能偷到最多的钱是多少
//     */
//    private int dp(int[] nums, int cur) {
//        //base case
//        if (cur < 0) return 0;
//        //0、先查备忘录
//        if (memo[cur] != -666) {
//            return memo[cur];
//        }
//        /*1、选择偷当前住户（前提是你上一家没有偷）
//         * 偷当前住户 = 当前住户家里的钱 + 上上家能偷到最多的钱的数量 */
//        int doIt = nums[cur] + dp(nums, cur - 2);
//        /*2、选择不偷当前住户
//         * 不偷当前住户 = 上一家能偷到钱的数量 （因为没有偷当前住户，所以金额保持不变）*/
//        int notDoIt = dp(nums, cur - 1);
//        //两个不同选择得到的最大值写入备忘录并返回
//        memo[cur] = Math.max(doIt, notDoIt);
//        return memo[cur];
//    }


 /*   public int rob(int[] nums) {
        //dp[i]定义为路过第 i 个住户偷到最大的金额,i有效范围[1,nums.length]
        int[] dp = new int[nums.length + 1];
        dp[1]=nums[0];
        for (int i = 2; i <= nums.length; i++) {
            //偷或不偷中，选择最大的
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length];
    }*/
}
