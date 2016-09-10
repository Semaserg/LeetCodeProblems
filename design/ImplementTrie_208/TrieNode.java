package LeetCode.design.ImplementTrie_208;

import java.util.Hashtable;

class TrieNode {
    public char key;
    public boolean hasInfo = false;
    public Hashtable<Character, TrieNode> children = new Hashtable<>();
    public TrieNode() {
    }
    public TrieNode(char key) {
        this.key = key;
    }
}
