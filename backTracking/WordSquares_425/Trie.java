package LeetCode.backTracking.WordSquares_425;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    char value;
    String word;
    Map<Character, TrieNode> children = new HashMap<>(); // can be array

    public TrieNode(char value) {
        this.value = value;
    }

    public boolean hasValue() {
        return this.word != null;
    }
}
public class Trie {
    private TrieNode root = new TrieNode('$');

    public void add(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode(c));
            }
            current = current.children.get(c);
        }
        current.word = word;
    }

    public TrieNode get(String prefix) {
        if (prefix == null || prefix.length() == 0) return null;
        TrieNode current = root;
        for(char c: prefix.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return null;
            }
        }
        return current;
    }

    public List<String> getByPrefix(String prefix) {
        TrieNode localRoot = this.get(prefix);
        List<String> result = new ArrayList<>();
        if (localRoot == null) return result;

        this.collect(result, localRoot);
        return result;
    }

    private void collect(List<String> result, TrieNode current) {
        if (current.hasValue()) {
            result.add(current.word);
            return;
        }
        for(TrieNode childNode : current.children.values()) {
            collect(result, childNode);
        }
    }

    public static Trie fromArray(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        return trie;
    }
}
