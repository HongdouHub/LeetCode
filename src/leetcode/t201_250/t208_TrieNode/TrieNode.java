package leetcode.t201_250.t208_TrieNode;

/**
 * 基本性质
 *
 * 1. 根结点不包含任何字符，除根结点外每个节点都只包含一个字符
 * 2. 从根结点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串
 * 3. 每个节点的所有子节点包含的字符都不相同
 */
public class TrieNode {

    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[58];

    public TrieNode() {
        //
    }

    public TrieNode(char val) {
        TrieNode node = new TrieNode();
        node.val = val;
    }
}
