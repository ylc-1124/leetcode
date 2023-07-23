package 树;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/
 */
public class Trie {
    private boolean isEnd;
    private Trie[] next;
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        Trie node = this;
        for (char c : cs) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Trie node = this;
        for (char c : cs) {
            if (node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        Trie node = this;
        for (char c : cs) {
            if (node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a'];
        }
        return true;
    }
}
