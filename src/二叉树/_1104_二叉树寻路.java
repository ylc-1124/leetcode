package 二叉树;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/
 */
public class _1104_二叉树寻路 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new LinkedList<>();
        while (label > 0) {
            ans.add(label);
            label >>= 1;
        }
        Collections.reverse(ans);
        int left = 1, right = 1, deep = ans.size();
        for (int i = 0; i < deep; i++) {
            if ((deep & 1) != (i & 1)) continue;
            left = 1 << i;
            right = (left << 1) - 1;
            ans.set(i, left + right - ans.get(i));
        }
        return ans;
    }
}
