package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_合并区间 {
    //AC 70个测试用例，不合题意
//    public int[][] merge(int[][] intervals) {
//        //找出最大边界，初始化标记数组
//        int high = Integer.MIN_VALUE;
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][1] > high) {
//                high = intervals[i][1];
//            }
//        }
//        boolean[] flags = new boolean[high + 1];
//
//        //将区间内的元素进行标记
//        for (int i = 0; i < intervals.length; i++) {
//            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
//                flags[j] = true;
//            }
//        }
//        List<List<Integer>> resList = new ArrayList<>();
//        int index = 0;
//        while (index < flags.length) {
//            ArrayList<Integer> list = new ArrayList<>();
//            while (index < flags.length && !flags[index]) index++;
//            list.add(index);
//            while (index < flags.length && flags[index]) index++;
//            list.add(index - 1);
//            resList.add(list);
//        }
//        int[][] res = new int[resList.size()][2];
//        for (int i = 0; i < res.length; i++) {
//            res[i][0] = resList.get(i).get(0);
//            res[i][1] = resList.get(i).get(1);
//        }
//        return res;
//    }

    public int[][] merge(int[][] intervals) {
        //按区间左端点升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                //按区间起点升序排列
                return intervals1[0] - intervals2[0];
            }
        });
        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //若当前区间的起点大于结果集最后一个区间的终点则不能合并，加入结果集
            int[] curInterval = intervals[i];
            int[] lastInterval = resList.get(resList.size() - 1);
            if (curInterval[0] > lastInterval[1]) {
                resList.add(curInterval);
            } else {
                //进行区间合并
                lastInterval[1] = Math.max(lastInterval[1], curInterval[1]);
            }
        }
        //转换成二维数组进行返回
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
