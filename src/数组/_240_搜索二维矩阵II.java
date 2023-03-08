package 数组;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/
 */
public class _240_搜索二维矩阵II {
    //使用二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            //每行进行二分查找
            if (binarySearch(matrix[i], 0, matrix[0].length - 1, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return false;
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] > target) {
            return binarySearch(arr, low, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, high, target);
        }
    }
}
