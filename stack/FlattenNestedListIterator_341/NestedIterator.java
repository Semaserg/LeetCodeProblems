package LeetCode.stack.FlattenNestedListIterator_341;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// Great solution
// https://discuss.leetcode.com/topic/42042/simple-java-solution-using-a-stack-with-explanation
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i=nestedList.size()-1; i>=0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }
            // if current item is array, pop this array, and push all the items from it to stack
            stack.pop();
            List<NestedInteger> list = curr.getList();
            for(int i=list.size()-1; i>=0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }
}