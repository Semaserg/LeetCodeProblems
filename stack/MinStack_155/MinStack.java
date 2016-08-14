package LeetCode.stack.MinStack_155;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
155. Min Stack
https://leetcode.com/problems/min-stack/

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
// Good solutions
// https://discuss.leetcode.com/topic/33199/clean-6ms-java-solution - use self made linked list,
// store min for each level of stack.
// https://discuss.leetcode.com/topic/41486/short-simple-java-solution-12-line - store in stack [val, min, val, min ...]
// https://discuss.leetcode.com/topic/4953/share-my-java-solution-with-only-one-stack - store diffs.
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Integer min;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (stack.empty() || x<min) {
            min = x;
        }
        stack.push(x);
    }

    // Time complexity O(n) worst case,  space complexity O(n) worst case.
    public void pop() {
        int x = stack.pop();
        if (x == min) {
            min = null;
            Stack<Integer> temp = new Stack<>();
            while (!stack.empty()) {
                int i = stack.pop();
                min = (min == null) ? i : Math.min(min, i);
                temp.push(i);
            }
            while (!temp.empty()) {
                stack.push(temp.pop());
            }
        }
        System.out.println("Min is: " + min);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}