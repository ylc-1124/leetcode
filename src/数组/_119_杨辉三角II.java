package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle-ii/
 */
public class _119_杨辉三角II {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>(rowIndex + 1);
        int a = 1;
        //初始化杨辉三角
        for (int i = 0; i < rowIndex + 1; i++) {
            ArrayList<Integer> list = new ArrayList<>(a);
            for (int j = 0; j < a; j++) {
                list.add(1);
            }
            res.add(list);
            a++;
        }
        //计算杨辉三角
        if (rowIndex >= 2) {
            for (int i = 2; i < res.size(); i++) {
                List<Integer> pre = res.get(i - 1);
                List<Integer> list = res.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (j == 0 || j == list.size() - 1) continue;
                    list.set(j, pre.get(j - 1) + pre.get(j));
                }
            }
        }
        return res.get(rowIndex);
    }

}
