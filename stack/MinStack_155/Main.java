package LeetCode.stack.MinStack_155;

public class Main {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.print(stack.getMin());
        stack.pop();
        stack.top();
        System.out.print(stack.getMin());
    }
}
