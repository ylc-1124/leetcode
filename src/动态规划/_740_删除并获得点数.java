package 动态规划;

public class _740_删除并获得点数 {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        // 统计各元素出现的个数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // freq[i]表示数字 i出现的次数
        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        //此时题目已经转换 ==> 打家劫舍问题

        // 对于前 i个房屋，最多获得 dp[i]块钱   0<= i<= max+1
        int[] dp = new int[max + 2];
        // base case
        dp[0] = 0;
        dp[1] = freq[0] * 0;
        dp[2] = freq[1] * 1;

        for (int i = 3; i <= max + 1; i++) {
            // 第 i个房子包含的金额为 freq[i - 1] * (i - 1)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + freq[i - 1] * (i - 1));
        }
        return dp[max + 1];
    }

}
