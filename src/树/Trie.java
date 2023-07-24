package 树;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/
 */
public class Trie { // 一个Trie结点对应一种字符，根节点不对应
    private boolean isEnd;
    private Trie[] next;
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        Trie node = this; // 从字典树的根结点开始向下搜索
        for (char c : cs) {
            if (node.next[c - 'a'] == null) { // 当前字符不存在于字典树中
                node.next[c - 'a'] = new Trie(); // 新增结点的存在意味着->当前字符存在于字典树中
            }
            node = node.next[c - 'a']; //向下搜索
        }
        node.isEnd = true; // 最后一个字符对应的结点设置flag意味是一个单词的结尾
    }

    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Trie node = this;
        for (char c : cs) {
            if (node.next[c - 'a'] == null) { //当前字符不存在于字典树
                return false;
            }
            node = node.next[c - 'a'];
        }
        // 单词的每个字符都存在于字典树中，且最后一个字符的确是某单词的结尾，说明单词存在
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        Trie node = this;
        for (char c : cs) {
            if (node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a']; // node指向下一个字符
        }
        // 字典树中可以搜索到当前字符串prefix，说明有以当前字符串为前缀的单词
        return true;
    }
}
