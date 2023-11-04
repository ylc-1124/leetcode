package 二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _117_填充每个节点的下一个右侧节点指针II {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 此时队列的大小代表了这一层有多少结点
            int n = queue.size();
            Node prev = null;
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

//    public Node connect(Node root) {
//        if (root == null) return null;
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            Node pre = null;
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                /*层序遍历代码位置*/
//                if (pre != null) {
//                    pre.next = node;
//                }
//                pre = node;
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return root;
//    }

}
