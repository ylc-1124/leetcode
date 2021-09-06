package 数组;

/**
 * https://leetcode-cn.com/problems/binary-search/
 */
public class _704_二分查找 {
    public int search(int[] nums, int target) {
        /*有效范围为 [begin , end) */
        int begin = 0, end = nums.length;
        while (begin < end) {
            int mid = begin - (begin - end) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) {
                end = mid;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            }
        }
        return -1;
    }
}
