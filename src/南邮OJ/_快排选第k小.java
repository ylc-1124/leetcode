package 南邮OJ;

/**
 * @description:
 * @author: ylc
 * @date: 2024/1/13 11:11
 */
public class _快排选第k小 {
    public static void main(String[] args) {

        int[] arr = new int[]{1,9,2,7,5,6, 4, 3, 8, 10};
        int k = 8;
        quickSort(arr, 0, arr.length - 1, k);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public static void quickSort(int[] arr, int low, int high, int k) {
        if (low < high) {
            int pivotpos = partition(arr, low, high);
            if (pivotpos == k - 1) {
                // 第k小元素排好了
                return;
            } else if (pivotpos > k - 1) {
                quickSort(arr, low, pivotpos - 1, k);
            } else {
                quickSort(arr, pivotpos + 1, high, k);
            }
        }
    }

    // 划分，返回轴点元素的最终位置
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
