package 数组;

/**
 * https://leetcode-cn.com/problems/remove-element/
 */
public class _27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
