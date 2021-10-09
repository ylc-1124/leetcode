package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs/
 */
public class _1530_好叶子节点对的数量 {
    int res;
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        //存放左子树所有叶子节点到左子树根节点的深度
        List<Integer> lefts = new LinkedList<>();
        dfs(root.left, 0, lefts);
        //右子树同理
        List<Integer> rights = new LinkedList<>();
        dfs(root.right, 0, rights);

        for (Integer left : lefts) {
            for (Integer right : rights) {
                if ((left + right + 2) <= distance) {
                    res++;
                }
            }
        }
        //树中每个节点的叶子节点都可能满足条件，所以此方法也要递归,确保所有可能都考虑到
        countPairs(root.left, distance);
        countPairs(root.right, distance);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;
        //遇到叶子节点则把深度加入到list中
        if (root.left == null && root.right == null) {
            list.add(depth);
        }
        dfs(root.left, depth + 1, list);
        dfs(root.right, depth + 1, list);
    }

}
