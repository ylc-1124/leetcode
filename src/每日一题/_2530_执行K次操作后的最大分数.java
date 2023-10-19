package 每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2530_执行K次操作后的最大分数 {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;  // 大根堆
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer max = heap.poll();
            score += max;
            heap.add((int) Math.ceil(max / 3.0));
        }

        return score;
    }
}
