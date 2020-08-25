package leetcode.t201_250.t212_FindWords;

import leetcode.t201_250.t208_TrieNode.TrieNode;

public class Trie {
    private static final char FLAG = 'A';

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - FLAG] == null) {
                node.children[c - FLAG] = new TrieNode(c);
            }
            node = node.children[c - FLAG];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - FLAG] == null)
                return false;
            node = node.children[c - FLAG];
        }
        return node.isWord;
    }

    public boolean startWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - FLAG] == null)
                return false;
            node = node.children[c - FLAG];
        }
        return true;
    }
}
