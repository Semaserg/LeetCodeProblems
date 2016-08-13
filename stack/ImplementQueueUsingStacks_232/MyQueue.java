package LeetCode.stack.ImplementQueueUsingStacks_232;

import java.util.Stack;

/*
232. Implement Queue using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only:
 push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively.
You may simulate a stack by using a list or deque (double-ended queue),
as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example,
 no pop or peek operations will be called on an empty queue).
*/
// My stupid solution
/*class MyQueue {
    private Stack<Integer> stack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        if (stack.empty()) {
            stack.push(x);
            return;
        }
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty()) {
            temp.push(stack.pop());
        }
        stack.push(x);
        while (!temp.empty()) {
            stack.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public int pop() {
        return stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}*/

// Good solution
// https://discuss.leetcode.com/topic/17974/short-o-1-amortized-c-java-ruby/2
class MyQueue {
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
       input.push(x);
    }

    // Time complexity O(n) worst case
    // Space complexity O(1)
    // Removes the element from in front of queue.
    public int pop() {
        moveIfNeeded();
        return output.pop();
    }

    // Get the front element.
    public int peek() {
        moveIfNeeded();
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty() && output.empty();
    }

    private void moveIfNeeded() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
    }
}