package LeetCode.design.ImplementHashTable_SeparateChaining;

/**
 * Created by Sergii on 09.01.2017.
 */
public class SeparateChainingHashTable<Key, Value> {
    private final int M = 97;
    private Object[] st = new Object[M];
    private class Node {
        public Key key;
        public Value value;
        public Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int getHash(Key key) {
        return key.hashCode()%M;
    }

    public void put(Key key, Value value) {
        int hash = getHash(key);
        for(Node n = (Node)st[hash]; n != null; n = n.next) {
            if (key.equals(n.key)) {
                n.value = value;
                return;
            }
        }
        st[hash] = new Node(key, value, (Node)st[hash]);
    }

    public Value get(Key key) {
        int hash = getHash(key);
        for (Node n = (Node)st[hash]; n != null; n = n.next) {
            if (key.equals(n.key)) return n.value;
        }
        return null;
    }

    public void remove(Key key) {
        int hash = getHash(key);
        // check first in linked list
        Node c = (Node)st[hash];
        if (key.equals(c.key)) {
            st[hash] = c.next;
            return;
        } else {
            Node prev = (Node)st[hash];
            Node curr = prev.next;
            while (curr != null) {
                if (!key.equals(curr.key)) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    return;
                }
            }
        }

    }
}
