package LeetCode.stack.ImplementStackUsingQueues_225;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.print(stack.top());
        stack.pop();
        System.out.print(stack.top());
        stack.pop();
        System.out.print(stack.top());
        stack.pop();
    }
}
