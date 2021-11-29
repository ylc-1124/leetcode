package 回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/gray-code/
 */
public class _89_格雷编码 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> grayCode(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(n, sb,new int[]{0,1});
        return res;
    }

    private void backtrack(int n, StringBuilder sb,int[] nums ) {
        if (sb.length() == n) {
            // 二进制转换为十进制
            res.add(Integer.valueOf(sb.toString(), 2));
            return;
        }
        sb.append(nums[0]);
        backtrack(n, sb,new int[]{0,1});
        sb.deleteCharAt(sb.length() - 1);

        sb.append(nums[1]);
        backtrack(n, sb,new int[]{1,0});
        sb.deleteCharAt(sb.length() - 1);
    }


}
