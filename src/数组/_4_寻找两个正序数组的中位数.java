package 数组;

public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] res = new double[nums1.length + nums2.length];
        merge(nums1, nums2, res);
        if (res.length % 2 == 0) {
            return (res[res.length / 2 - 1] + res[res.length / 2]) / 2;
        } else {
            return res[res.length / 2];
        }
    }

    private void merge(int[] nums1, int[] nums2, double[] res) {
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] <= nums2[p2]) {
                res[p3++] = nums1[p1++];
            } else {
                res[p3++] = nums2[p2++];
            }
        }
        //nums1中有数据
        while (p1 < nums1.length) {
            res[p3++] = nums1[p1++];
        }
        //nums2中有数据
        while (p2 < nums2.length) {
            res[p3++] = nums2[p2++];
        }
    }
}
