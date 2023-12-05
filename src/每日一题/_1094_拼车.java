package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/2 14:57
 */
public class _1094_拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        // 按乘客的上车地点排序
        Arrays.sort(trips, (o1, o2) -> o1[1] - o2[1]);
        // 上车的乘客按下车位置排序
        Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int[] trip : trips) {
            // 如果当前乘客上车位置 >= 堆顶要下车的位置，腾出位置
            while (!heap.isEmpty() && trip[1] >= heap.peek()[2]) {
                int[] passenger = heap.poll();
                // 乘客下车
                capacity += passenger[0];
            }
            // 乘客上车
            capacity -= trip[0];
            if (capacity < 0) {
                return false;
            }
            // 添加上车乘客信息
            heap.add(trip);
        }
        return true;
    }
}
