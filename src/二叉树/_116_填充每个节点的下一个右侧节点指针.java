package 二叉树;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class _116_填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        return connect(root, null);
    }

    private Node connect(Node node, Node parent) {
        if (node == null) return null;
        if (parent != null) {
            if (node == parent.left) {
                //当前节点是左孩子节点：直接问父节点要兄弟节点
                node.next = parent.right;
            } else if (parent.next != null) {
                //当前节点是右孩子节点：问父节点的兄弟要左孩子
                node.next = parent.next.left;
            }
        }
        connect(node.left, node);
        connect(node.right, node);
        return node;
    }
//    public Node connect(Node root) {
//        if (root == null) return null;
//        connectTwoNode(root.left, root.right);
//        return root;
//    }
//
//    private void connectTwoNode(Node node1, Node node2) {
//        if (node1 == null || node2 == null) return;
//        /*前序遍历部分*/
//        node1.next = node2;
//
//        connectTwoNode(node1.left, node1.right);
//        connectTwoNode(node2.left, node2.right);
//        connectTwoNode(node1.right, node2.left);
//
//    }
}
