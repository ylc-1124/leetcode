package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 */
public class _662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int res = 0, left = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0; //将所有节点都存上他在这一层的编号
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                //找到最左的节点记录值
                if (i == 0) {
                    left= node.val;
                }
                //找到最右的节点，开始算与最左的节点直接的宽度
                if (i == levelSize - 1) {
                    res = Math.max(res, node.val - left + 1);
                }
                //在层序遍历固定框架上稍作修改
                if (node.left != null) {
                    node.left.val = node.val << 1;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = (node.val << 1) + 1;
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
