package 每日一题;

import java.util.Arrays;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/29 14:42
 */
public class SmallestInfiniteSet {
    private boolean[] arr;
    public SmallestInfiniteSet() {
        arr = new boolean[1001]; // [1...1000]是有效下标
        Arrays.fill(arr, true);
    }

    public int popSmallest() {
        for (int i = 1; i <= 1000; i++) {
            if (arr[i]) {
                arr[i] = false;
                return i;
            }
        }
        return 1001;
    }

    public void addBack(int num) {
        arr[num] = true;
    }
}
