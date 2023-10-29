package 每日一题;

import java.util.Arrays;

public class _274_H指数 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // 1 1 3
        int hIndex = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > hIndex) hIndex++;
        }
        return hIndex;
    }
}
