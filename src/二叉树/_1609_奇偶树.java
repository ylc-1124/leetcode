package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/even-odd-tree/
 */
public class _1609_奇偶树 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int pre = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                int cur = node.val;
                if (i == 0) {
                    //每一层的第一个节点只要判断奇偶性
                    pre = cur;
                    if (isEven(level) && isEven(cur)) return false;
                    if (!isEven(level) && !isEven(cur)) return false;
                    continue;
                } else {
                    if (isEven(level)) {
                        if (isEven(cur) || pre >= cur) return false;
                    } else {
                        if (!isEven(cur) || pre <= cur) return false;
                    }
                    pre = cur;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return true;
    }

    /**
     * 判断是否为偶数
     */
    private boolean isEven(int val) {
        return (val & 1) == 0;
    }
}
