package leetcode.preparation.trie;

public interface ITrie {
    int FLAG = 'A';

    /** Inserts a word into the trie. */
    void insert(String word);

    /** Returns if the word is in the trie. */
    boolean search(String word);

    /** Returns if there is any word in the trie that starts with the given prefix. */
    boolean startsWith(String prefix);

}
