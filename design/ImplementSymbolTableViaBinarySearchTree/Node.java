package LeetCode.design.ImplementSymbolTableViaBinarySearchTree;

/**
 * BST node class.
 */
public class Node<Key extends Comparable<Key>, Value> {
    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.count = 1;
    }

    public Key key;
    public Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;
    public int count;

    @Override
    public String toString() {
        return key + " " + value + count;
    }
}
