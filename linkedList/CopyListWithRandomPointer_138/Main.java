package LeetCode.linkedList.CopyListWithRandomPointer_138;

public class Main {
    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);

        a.next = b;
        a.random = e;

        b.next = c;
        c.next = d;
        d.next = e;
        e.random = a;

        Solution s = new Solution();
        RandomListNode clone = s.copyRandomList(a);

        System.out.print(clone);
    }
}
