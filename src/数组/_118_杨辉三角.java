package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle/
 */
public class _118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int capacity = 1;
        //初始化杨辉三角
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>(capacity);
            for (int j = 0; j < capacity; j++) {
                list.add(1);
            }
            res.add(list);
            capacity++;
        }
        //从第三层开始计算杨辉三角
        if (numRows > 2) {
            for (int i = 2; i < numRows; i++) {
                List<Integer> preList = res.get(i - 1); //上一层数据
                List<Integer> list = res.get(i);
                for (int j = 0; j < list.size(); j++) {
                    //首尾必然是1不用处理
                    if (j == 0 || j == list.size() - 1) continue;
                    Integer a = preList.get(j - 1);
                    Integer b = preList.get(j);
                    list.set(j, a + b);
                }
            }
        }
        return res;
    }

}
