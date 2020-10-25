package leetcode.preparation.trie;

public class TrieNode {

    public char val;
    public boolean isWord;
    // 从A开始到z一共58个字符（26 * 2 + 6）
    public TrieNode[] children = new TrieNode[58];

    public TrieNode() {
        //
    }

    public TrieNode(char val) {
        this.val = val;
    }
}
