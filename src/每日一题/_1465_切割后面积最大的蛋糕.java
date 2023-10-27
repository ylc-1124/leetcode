package 每日一题;

import java.math.BigInteger;
import java.util.Arrays;

public class _1465_切割后面积最大的蛋糕 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int m = horizontalCuts.length;
        int n = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int[] high = new int[m + 1];
        int[] width = new int[n + 1];
        high[0] = horizontalCuts[0];
        high[m] = h - horizontalCuts[m - 1];
        for (int i = 1; i <= m - 1; i++) {
            high[i] = horizontalCuts[i] - horizontalCuts[i - 1];
        }
        width[0] = verticalCuts[0];
        width[n] = w - verticalCuts[n - 1];
        for (int i = 1; i <= n - 1; i++) {
            width[i] = verticalCuts[i] - verticalCuts[i - 1];
        }

        int max_high = Integer.MIN_VALUE, max_width = Integer.MIN_VALUE;
        for (int i = 0; i < high.length; i++) {
            max_high = Math.max(high[i], max_high);
        }
        for (int i = 0; i < width.length; i++) {
            max_width = Math.max(width[i], max_width);
        }

        return (int) ((long) max_high * max_width % 1000000007);
    }

}
