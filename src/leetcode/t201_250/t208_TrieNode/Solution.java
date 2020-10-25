package leetcode.t201_250.t208_TrieNode;

import leetcode.preparation.trie.Trie;

/**
 * 208. 实现 Trie (前缀树 / 字典树)
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *      Trie trie = new Trie();
 *
 *      trie.insert("apple");
 *      trie.search("apple");   // 返回 true
 *      trie.search("app");     // 返回 false
 *      trie.startsWith("app"); // 返回 true
 *      trie.insert("app");
 *      trie.search("app");     // 返回 true
 *
 * 说明:
 *     你可以假设所有的输入都是由小写字母 a-z 构成的。
 *     保证所有输入均为非空字符串。
 */
public class Solution {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ABCDEFabc");

        System.out.println(trie.search("ABCD"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ABCDEFabc"));

        System.out.println(trie.startsWith("ABCD"));
        System.out.println(trie.startsWith("abc"));
        System.out.println(trie.startsWith("ABCDEFabc"));

    }
}
