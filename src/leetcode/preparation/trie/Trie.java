package leetcode.preparation.trie;

public class Trie implements ITrie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    @Override
    public void insert(String word) {
        TrieNode node = root;
        int index;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            index = c - FLAG;

            if (node.children[index] == null) {
                node.children[index] = new TrieNode(c);
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    @Override
    public boolean search(String word) {
        if (word == null) {
            if (root == null) {
                return true;
            }
            for (int i = 0; i < root.children.length; i++) {
                if (root.children[i] != null) {
                    return false;
                }
            }
            return true;
        }

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - FLAG] == null) {
                return false;
            }
            node = node.children[c - FLAG];
        }
        return node.isWord;
    }

    @Override
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - FLAG] == null) {
                return false;
            }
            node = node.children[c - FLAG];
        }
        return true;
    }
}
