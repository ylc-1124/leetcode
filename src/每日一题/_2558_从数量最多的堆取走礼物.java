package 每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2558_从数量最多的堆取走礼物 {
    public long pickGifts(int[] gifts, int k) {
        // 大根堆
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 初始建堆
        for (int i = 0; i < gifts.length; i++) {
            heap.add(gifts[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer max = heap.poll();
            heap.add((int) Math.sqrt(max));
        }
        // 计算结果
        long res = 0;
        for (Integer i : heap) {
            res += i;
        }

        return res;
    }
}
