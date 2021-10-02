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
        //传入的树本身已经是完全二叉树了，初始化的时候只做一件事--BFS记录所有节点
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

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        list.add(node);
        int size = list.size();
        //父节点的索引
        int index = (size & 1) == 0 ?
                (size >> 1) - 1 : ((size + 1) >> 1) - 2;
        TreeNode parent = list.get(index);
        if ((size & 1) == 0) {
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
