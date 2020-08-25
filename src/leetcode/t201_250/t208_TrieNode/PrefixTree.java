package leetcode.t201_250.t208_TrieNode;

/**
 * 实现字典树
 */
public class PrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ABCDEFabc");

        System.out.println(trie.search("ABCD"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ABCDEFabc"));

        System.out.println(trie.startWith("ABCD"));
        System.out.println(trie.startWith("abc"));
        System.out.println(trie.startWith("ABCDEFabc"));

    }
}
