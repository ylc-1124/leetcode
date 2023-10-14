package 每日一题;

public class _2562_找出数组的串联值 {
    public long findTheArrayConcVal(int[] nums) {
        long res = 0L;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            Long n;
            if (left != right) {
                n = Long.valueOf(String.valueOf(nums[left]) + String.valueOf(nums[right]));
            } else {
                n = Long.valueOf(nums[left]);
            }
            res += n;

            left++;
            right--;
        }
        return res;
    }
}
