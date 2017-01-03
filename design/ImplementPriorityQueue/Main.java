package LeetCode.design.ImplementPriorityQueue;

public class Main {
    public static void main(String[] args) {
        MyPriorityQueue q = new MyPriorityQueue(5);
        q.insert(10);
        q.insert(2);
        q.insert(101);
        q.insert(6);
        q.insert(4);
        System.out.println(q.delMax());
        System.out.println(q.delMax());
        System.out.println(q.delMax());
        System.out.println(q.delMax());
        System.out.println(q.delMax());
    }
}


