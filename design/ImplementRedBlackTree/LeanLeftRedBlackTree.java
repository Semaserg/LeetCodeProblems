package LeetCode.design.ImplementRedBlackTree;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;

/**
 * Symbol Table class implemented via Binary Search Tree (BST)
 */
public class LeanLeftRedBlackTree<Key extends Comparable<Key>, Value> {
    private Node<Key,Value> root;

    public LeanLeftRedBlackTree(){}

    public void put(Key key, Value value) {
       root = put(root, key, value);
    }

    private Node put(Node curr, Key key, Value value) {
        if (curr == null) return new Node(key, value, Node.RED);
        int cmp = key.compareTo((Key)curr.key);
        if (cmp < 0) {
            curr.left = put(curr.left, key, value);
            curr.count++;
        } else if (cmp > 0) {
            curr.right = put(curr.right, key, value);
            curr.count++;
        }
        else curr.value = value;

        if (isRed(curr.right) && !isRed(curr.left))
            curr = rotateLeft(curr);
        if (isRed(curr.left) && curr.left != null && isRed(curr.left.left))
            curr = rotateRight(curr);
        if (isRed(curr.right) && isRed(curr.left))
            flipColors(curr);
        return curr;
    }

    private Node rotateLeft(Node h) {
        assert !isRed(h);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Node.RED;
        return x;
    }

    private Node rotateRight(Node h) {
        assert !isRed(h);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Node.RED;
        return x;
    }

    private void flipColors(Node h) {
        assert (!isRed(h));
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = Node.RED;
        h.left.color = Node.BLACK;
        h.right.color = Node.BLACK;
    }
    private boolean isRed(Node node) {
        return node != null && node.color == Node.RED;
    }

    public Value get(Key key){
        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo((Key)curr.key);
            if (cmp < 0) curr = curr.left;
            else if (cmp > 0) curr = curr.right;
            else {
                return (Value)curr.value;
            }
         }
        return null;
    }

    public void delete( Key key) {
        root = delete(root, key);
    }

    private Node delete(Node current, Key key) {
        throw new NotImplementedException();
    }


    public void deleteMin(){
        throw new NotImplementedException();
    }

    public void deleteMax(){
        throw new NotImplementedException();
    }


    public boolean contains(Key key){
        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo((Key)curr.key);
            if (cmp < 0) curr = curr.left;
            else if (cmp > 0) curr = curr.right;
            else {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Value min(){
        Node curr = root;
        while (curr.left != null) curr = curr.left;
        return (Value)curr.value;
    }

    public Value max(){
        Node curr = root;
        while (curr.right != null) curr = curr.right;
        return (Value)curr.value;
    }

    public int size(){
        return root.count;
    }

    public int size(Key lo, Key hi){
        throw new NotImplementedException();
    }

    Iterable<Key> keys() {
        LinkedList<Key> list = new LinkedList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(Node curr, LinkedList<Key> list) {
        if (curr == null) return;
        inorder(curr.left, list);
        list.add((Key)curr.key);
        inorder(curr.right, list);
    }


    Iterable<Key> keys(Key lo, Key hi) {
        throw new NotImplementedException();
    }

    public Key floor(Key key){
        throw new NotImplementedException();
    }

    public Key ceiling(Key key){
        throw new NotImplementedException();
    }

    public int rank(Key key){
        throw new NotImplementedException();
    }


    public Key select(int k){
        throw new NotImplementedException();
    }


}
