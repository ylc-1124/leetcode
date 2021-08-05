package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class _102_二叉树的层序遍历 {
    //实现思路：使用队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>(); //存放二叉树结点的队列
        queue.offer(root); //根节点入队
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size= queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();   //队头结点出队
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
