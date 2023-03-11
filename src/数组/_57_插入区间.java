package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/insert-interval/description/
 */
public class _57_插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //构建插入新区间后的区间集合
        int[][] newIntervals = new int[intervals.length + 1][2];
        newIntervals[0] = newInterval;
        for (int i = 1; i < newIntervals.length; i++) {
            newIntervals[i] = intervals[i - 1];
        }
        //区间按起点排序
        Arrays.sort(newIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> resList = new ArrayList<>();
        resList.add(newIntervals[0]);
        for (int i = 1; i < newIntervals.length; i++) {
            int[] curInterval = newIntervals[i];
            int[] lastInterval = resList.get(resList.size() - 1);
            if (curInterval[0] > lastInterval[1]) {
                resList.add(curInterval);
            } else {
                //合并
                lastInterval[1] = Math.max(lastInterval[1], curInterval[1]);
            }
        }
        //转换为二维数组
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
