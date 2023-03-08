package 二叉树;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLFault;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {

    //每个节点的统一任务：交换左右子树 --> 递归框架 -->
    //                 所有节点都完成了这个任务后 --> 翻转二叉树成功
    public TreeNode invertTree(TreeNode root) {
        //base case
        if (root == null) return null;
        //前序遍历位置：交换当前节点的左右子树
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
//    //方法一：层序遍历
//    public TreeNode invertTree2(TreeNode root) {
//        if(root==null) return root;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            TreeNode tmp = node.left;
//            node.left = node.right;
//            node.right = tmp;
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//        return root;
//    }
//
//    /**
//     *  翻转以root为根节点的树
//     */
//    public TreeNode invertTree(TreeNode root) {
//       if (root == null) return null;
//
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//        return root;
//    }

}
