package 数组;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = leftSearch(nums, target);
        ans[1] = rightSearch(nums, target);

        return ans;
    }

    private int leftSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    public int rightSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (mid == nums.length - 1 || nums[mid + 1] != target) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ans = new _34_在排序数组中查找元素的第一个和最后一个位置().searchRange(arr, target);
        for (int date : ans) {
            System.out.println(date);
        }
    }
}
