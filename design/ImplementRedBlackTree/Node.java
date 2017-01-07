package LeetCode.design.ImplementRedBlackTree;

/**
 * Node implementation
 */
public class Node<Key extends Comparable<Key>, Value> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    public Node(Key key, Value value, boolean color) {
        this.key = key;
        this.value = value;
        this.count = 1;
        this.color = color;
    }

    public Key key;
    public Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;
    public boolean color;
    public int count;

    @Override
    public String toString() {
        return key + " " + value + " " + count;
    }
}
