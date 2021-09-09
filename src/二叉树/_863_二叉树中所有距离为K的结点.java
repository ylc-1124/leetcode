package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class _863_二叉树中所有距离为K的结点 {
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        createMap(root, null);
        List<Integer> res = new LinkedList<>();
        if (k == 0) {
            res.add(target.val);
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int step = 0;
        while (!queue.isEmpty()) {
            step++; //node往外扩散的节点离node的距离
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    if (step == k) {
                        res.add(node.left.val);
                    }
                    queue.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    if (step == k) {
                        res.add(node.right.val);
                    }
                    queue.offer(node.right);
                    visited.add(node.right);
                }

                TreeNode parent = parents.get(node);
                if (parent != null && !visited.contains(parent)) {
                    if (step == k) {
                        res.add(parent.val);
                    }
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            if (step == k) break;
        }
        return res;
    }

    private void createMap(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parents.put(root, parent);
        createMap(root.left, root);
        createMap(root.right, root);
    }

   /*     //维护所有节点和其父节点的映射关系
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        //判断节点是否访问过
        Set<TreeNode> visited = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        createMap(root, null);
        List<Integer> res = new LinkedList<>();
        dfs(target, res, k);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int distance) {
         if (root == null || visited.contains(root)) return;
        visited.add(root);
        if (distance <= 0) {
            //当前节点的值 离target节点距离为k
            res.add(root.val);
            return;
        }
        dfs(root.left, res, distance - 1);
        dfs(root.right, res, distance - 1);
        dfs(parents.get(root), res, distance - 1);


    }

    private void createMap(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parents.put(root, parent);
        createMap(root.left, root);
        createMap(root.right, root);
    }*/
}
