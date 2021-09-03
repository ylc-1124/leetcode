package 数组;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class _面试题17_14_最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        Integer[] integers = new Integer[arr.length];

        int[] res = new int[k];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = arr[i];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Arrays.asList(integers));
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
