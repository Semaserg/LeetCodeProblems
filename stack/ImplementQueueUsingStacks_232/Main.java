package LeetCode.stack.ImplementQueueUsingStacks_232;

public class Main {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.print(q.pop() + " " + q.pop() + " " + q.pop());
    }
}
