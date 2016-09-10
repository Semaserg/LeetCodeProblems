package LeetCode.design.ImplementTrie_208;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("cap");
        trie.insert("capitan");
        trie.insert("america");
        System.out.println(trie.search("cap"));
        System.out.println(trie.startsWith("capi"));
    }
}


