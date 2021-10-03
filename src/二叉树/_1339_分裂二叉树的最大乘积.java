package 二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree/
 */
public class _1339_分裂二叉树的最大乘积 {
    List<Long> list = new LinkedList<>(); //存储每颗树的和
    long res;
    public int maxProduct(TreeNode root) {
        long sum = treeSum(root);
        for (Long val : list) {
            res = Math.max(res, (sum - val) * val);
        }
        return (int) (res % 1_000_000_007);
    }

    private long treeSum(TreeNode root) {
        if (root == null) return 0;
        long sum = root.val + treeSum(root.left) + treeSum(root.right);
        list.add(sum);
        return sum;
    }
}
