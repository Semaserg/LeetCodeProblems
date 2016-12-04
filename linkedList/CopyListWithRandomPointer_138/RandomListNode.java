package LeetCode.linkedList.CopyListWithRandomPointer_138;

public class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;
    RandomListNode(int x) { this.label = x; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        RandomListNode current = this;
        while (current != null) {
            sb.append(current.label + "->");
            current = current.next;
        }
        return sb.toString();
    }
}
