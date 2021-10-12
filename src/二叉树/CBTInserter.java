package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/complete-binary-tree-inserter/
 */
public class CBTInserter {
    private List<TreeNode> list = new LinkedList<>();
    public CBTInserter(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        list.add(node);
        int index = list.size() - 1; //node在list中的索引
        int pIndex = index % 2 != 0 ? (index - 1) >> 1 : (index - 2) >> 1;
        TreeNode parent = list.get(pIndex);
        if (index % 2 != 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }
}
