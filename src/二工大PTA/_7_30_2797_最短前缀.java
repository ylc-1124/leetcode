package 二工大PTA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _7_30_2797_最短前缀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.isEmpty()) {
                break;
            } else {
                list.add(str);
            }
        }
        Trie trie = new Trie(); // 创建根节点
        //初始化前缀树
        for (String s : list) {
            trie.insert(s);
        }
        //打印最短前缀
        for (String s : list) {
            System.out.printf("%s %s\n", s, trie.searchMinPrefix(s));
        }

    }

    /**
     * 字典树
     */
    static class Trie {
        private boolean isEnd;
        private Trie[] next;
        private int numWords; //有多少单词共享该结点
        public Trie() {
            isEnd = false;
            next = new Trie[26];
            numWords = 1;
        }

        public void insert(String word) {
            char[] cs = word.toCharArray();
            Trie node = this;
            for (char c : cs) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new Trie();
                } else {
                    // 为了找最短前缀
                    node.next[c - 'a'].numWords++;
                }
                node = node.next[c - 'a'];
            }
            node.isEnd = true;
        }

        //查找字典树中已存在单词的最小前缀
        public String searchMinPrefix(String word) {
            char[] cs = word.toCharArray();
            Trie node = this;
            String minPrefix = "";
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];
                if (node.next[c - 'a'] != null) {
                    minPrefix += c;
                    if (node.next[c - 'a'].numWords == 1) {
                        // 唯一前缀
                        return minPrefix;
                    } else if (i == cs.length - 1 && node.next[c - 'a'].isEnd) {
                        // 精确匹配
                        return minPrefix;
                    }
                    node = node.next[c - 'a'];
                }
            }
            return null;
        }
    }
}
