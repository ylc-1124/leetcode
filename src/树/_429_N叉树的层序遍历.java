package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class _429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new LinkedList<>();
        //结果列表
        List<List<Integer>> result = new LinkedList<>();
        //bfs离不开队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); //记录在同一层的结点数量
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                //层序遍历代码位置
                levelList.add(node.val);
                //所有非空子树入队
                for (Node child : node.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            result.add(levelList);
        }
        return result;
    }
}
