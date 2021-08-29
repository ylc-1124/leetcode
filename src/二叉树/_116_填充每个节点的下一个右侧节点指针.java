package 二叉树;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class _116_填充每个节点的下一个右侧节点指针 {
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;
        /*前序遍历部分*/
        node1.next = node2;

        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);

    }
}
