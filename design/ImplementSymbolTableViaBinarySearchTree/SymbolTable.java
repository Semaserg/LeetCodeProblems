package LeetCode.design.ImplementSymbolTableViaBinarySearchTree;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.LinkedList;

/**
 * Symbol Table class implemented via Binary Search Tree (BST)
 */
public class SymbolTable<Key extends Comparable<Key>, Value> {
    private Node<Key,Value> root;

    public SymbolTable(){}

    public void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new RuntimeException();
        }
        root = put(root, key, value);
    }

    private Node<Key, Value> put(Node parent, Key key, Value value) {
        if (parent == null) return new Node<>(key, value);
        int cmp = parent.key.compareTo(key);
        if (cmp > 0) {
            parent.left = put(parent.left, key, value);
            parent.count++;
        } else if (cmp < 0) {
            parent.right = put(parent.right, key, value);
            parent.count++;
        } else {
            parent.value = value;
        }
        return parent;
    }

    public Value get(Key key){
        Node curr = root;
        while (curr != null) {
            int cmp = curr.key.compareTo(key);
            if (cmp > 0) {
                curr = curr.left;
            } else if (cmp < 0) {
                curr = curr.right;
            } else {
                return (Value)curr.value;
            }
        }
        return null;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node current, Key key) {
        if (current == null) return  null;
        int cmp = current.key.compareTo(key);
        if (cmp > 0) current.left = delete(current.left, key);
        else if (cmp < 0) current.right = delete(current.right, key);
        else {
            if (current.right == null) return current.left;
            if (current.left == null) return current.right;
            Node temp = current;
            current = minNode(current.right); // get min from current subtree - X, X - is new current
            current.right = deleteMin(current.right); // remove X
            current.left = temp.left;
        }
        int leftCnt = current.left == null ? 0 : current.left.count;
        int rightCnt = current.right == null ? 0 : current.right.count;
        current.count = 1 + leftCnt + rightCnt;
        return current;
    }

    private Node minNode(Node current){
        Node curr = current;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node current) {
        if (current == null || (current.right == null && current.left == null)) return null;
        if (current.left == null) return current.right;
        current.left = deleteMin(current.left);
        int leftCnt = current.left == null ? 0 : current.left.count;
        int rightCnt = current.right == null ? 0 : current.right.count;
        current.count = 1 + leftCnt + rightCnt;
        return current;
    }

    public void deleteMax(){
        root = deleteMax(root);
    }

    private Node deleteMax(Node current) {
        if (current == null || (current.right == null && current.left == null)) return null;
        if (current.right == null) return current.left;
        current.right = deleteMin(current.right);
        int leftCnt = current.left == null ? 0 : current.left.count;
        int rightCnt = current.right == null ? 0 : current.right.count;
        current.count = 1 + leftCnt + rightCnt;
        return current;
    }

    public boolean contains(Key key){
        Node curr = root;
        while (curr != null) {
            int cmp = curr.key.compareTo(key);
            if (cmp < 0) { curr = curr.right; }
            else if (cmp > 0) { curr = curr.left; }
            else {return true; }
        }
        return false;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public Value min(){
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return (Value)curr.value;
    }

    public Value max(){
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
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

    private void inorder(Node current, LinkedList<Key> list) {
        if (current == null) return;
        inorder(current.left, list);
        list.add((Key)current.key);
        inorder(current.right, list);
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
        return rank(key, root);
    }

    private int rank(Key key, Node curr) {
        if (curr == null) return 0;
        int cmp = curr.key.compareTo(key);
        if (cmp > 0) {
            return rank(key, curr.left);
        } else if (cmp < 0) {
            return 1 + curr.left.count + rank(key, curr.right);
        } else {
            return curr.left.count;
        }
    }

    public Key select(int k){
        throw new NotImplementedException();
    }


}
