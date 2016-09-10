package LeetCode.design.ImplementTrie_208;

/*
 208. Implement Trie (Prefix Tree)
 https://leetcode.com/problems/implement-trie-prefix-tree/

 Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
// Great solution with array instead of hashtable.
// https://discuss.leetcode.com/topic/19221/ac-java-solution-simple-using-single-array/2
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    // Time complexity O(word.len)
    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode(c));
            }
            curr = curr.children.get(c);
        }
        curr.hasInfo = true;
    }

    // Returns if the word is in the trie.
    // Time complexity O(word.len)
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
        return curr.hasInfo;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    // Time complexity O(prefix.len)
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
        }
        return curr != root;
    }
}