package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {
    //方法一：递归
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int left = maxDepth(root.left); //递归左子树,返回当前结点左子树的深度
        int right = maxDepth(root.right); //递归右子树,返回当前结点右子树的深度
        return Math.max(left, right) + 1;
    }

    //方法二：层序遍历
  /*  public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;  //树的深度
        int levelSize = 1;  //存储每一层结点数量
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelSize--;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) { //意味着即将访问下一层
                depth++;
                levelSize= queue.size();
            }
        }
        return depth;
    }*/
}
