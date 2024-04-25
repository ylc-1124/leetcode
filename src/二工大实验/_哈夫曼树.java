package 二工大实验;

import java.util.*;

/**
 * @description:
 * @author: ylc
 * @date: 2023/12/27 10:11
 */
public class _哈夫曼树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // n个字符
        String[] values = new String[n];
        int[] freqs = new int[n]; // 频率
        for (int i = 0; i < n; i++) {
            values[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            freqs[i] = sc.nextInt();
        }

        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> o1.freq - o2.freq);
        // 构建 Node，存入小根堆
        for (int i = 0; i < n; i++) {
            Node node = new Node(values[i], freqs[i]);
            heap.add(node);
        }

        while (heap.size() >= 2) {
            Node n1 = heap.poll();
            Node n2 = heap.poll();
            Node newNode = new Node(null, n1.freq + n2.freq);
            newNode.left = n1;
            newNode.right = n2;

            heap.add(newNode);
        }

        if (heap.isEmpty()) {
            throw new RuntimeException("构造Huffman树失败");
        } else {
            Node root = heap.poll();
            List<Integer> code = new ArrayList<>();
            // 遍历 Huffman树，打印编码结果
            dfs(root, code);
        }

    }

    public static void dfs(Node root, List<Integer> code) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            // 打印编码
            System.out.print(root.value + ": ");
            for (Integer i : code) {
                System.out.print(i);
            }
            System.out.println();
        }

        code.add(0);
        dfs(root.left, code);
        code.remove(code.size() - 1);

        code.add(1);
        dfs(root.right, code);
        code.remove(code.size() - 1);
    }

    static class Node {
        String value;
        int freq;
        Node left;
        Node right;


        public Node() {
        }

        public Node(String value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
}
