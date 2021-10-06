package 二叉树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/validate-binary-tree-nodes/
 */
public class _1361_验证二叉树 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        //1、通过入度 找到根节点的编号

        //遍历左右子树的数组，值非-1的表示有一条边指向此节点
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                //索引代表节点的编号，值代表有多少条边指向此节点
                inDegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
            }
        }
        int root = -1; //根节点编号
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                root = i;
                break;
            }
        }
        //没有找到入度为0的节点，不符合二叉树性质
        if (root == -1) return false;

        //2、BFS 访问所有节点并加入到访问集合中
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            int lChild = leftChild[parent], rChild = rightChild[parent];
            if (lChild != -1) {
                if (visited.contains(lChild)) return false;
                queue.offer(lChild);
                visited.add(lChild);
            }
            if (rChild != -1) {
                if (visited.contains(rChild)) return false;
                queue.offer(rChild);
                visited.add(rChild);
            }
        }

        //每个节点都应该被访问到
        return visited.size() == n;
    }
}
