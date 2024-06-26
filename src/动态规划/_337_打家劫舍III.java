package 动态规划;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class _337_打家劫舍III {
    /**
     * 对于 root为根节点的一片房屋中，最多能偷到的金额为 rob(root)
     */
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);

        // 抢当前结点
        int doIt = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        // 不抢当前结点
        int notDoIt = rob(root.left) + rob(root.right);

        int maxMoney = Math.max(doIt, notDoIt);
        memo.put(root, maxMoney);

        return maxMoney;
    }

//    Map<TreeNode, Integer> memo = new HashMap<>();
//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        if (memo.containsKey(root)) {
//            return memo.get(root);
//        }
//        //抢当前节点
//        int doIt = root.val
//                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
//                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
//
//        //不抢当前节点
//        int notDoIt = rob(root.left) + rob(root.right);
//
//        int maxMoney = Math.max(doIt, notDoIt);
//        memo.put(root, maxMoney);
//
//        return maxMoney;
//    }
}
