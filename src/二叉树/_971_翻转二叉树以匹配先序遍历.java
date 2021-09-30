package 二叉树;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal/
 */
public class _971_翻转二叉树以匹配先序遍历 {
    boolean stop; //结束标记 默认初始值false
    int index;  //索引每次递归前自增
    List<Integer> res = new LinkedList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //如果一开始根节点值就不匹配，直接返回-1，如果进了递归，因为父节点为null会空指针异常
        if (root.val != voyage[0]) {
            res.add(-1);
            return res;
        }
        dfs(root, null, voyage);
        return res;
    }

    private void dfs(TreeNode root, TreeNode parent, int[] voyage) {
        //根节点为null或者结束标记stop为true时候直接返回
        if (root == null || stop) return;
        //当前节点的值和先序遍历数组对应的值不匹配
        if (root.val != voyage[index]) {
            //看看兄弟节点值能不能匹配上结果
            if (parent.right != null && parent.right.val == voyage[index]) {
                //匹配上了翻转左右子树，并把父节点添加到列表中
                TreeNode tmp = parent.right;
                parent.right = parent.left;
                parent.left = tmp;

                //小细节：这里需要维护一下root，指向翻转后的左子树
                root = parent.left;
                res.add(parent.val);
            } else {
                //试图翻转左右子树匹配失败
                //小细节：这里要先清空一下列表
                res.clear();
                res.add(-1);
                stop = true;
            }
        }
        index++;
        dfs(root.left, root, voyage);
        dfs(root.right, root, voyage);
    }
}
