package 二叉树;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class _297_二叉树的序列化与反序列化 {

    final String SEP = ",";
    final String NULL_NODE = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_NODE).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SEP);
        LinkedList<String> list = new LinkedList<>();
        for (String node : nodes) {
            list.add(node);
        }
        return deserialize(list);
    }

    /**
     * 删除链表第一个字符串，将其作为树的根节点返回
     */
    private TreeNode deserialize(LinkedList<String> list) {
        if (list.isEmpty()) return null;
        String node = list.removeFirst();
        if (node.equals(NULL_NODE)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));

        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }
}
