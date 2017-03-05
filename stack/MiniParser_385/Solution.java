package LeetCode.stack.MiniParser_385;

/*
385. Mini Parser
https://leetcode.com/problems/mini-parser/

Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
*/

import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    // Time complexity O(4n) => O(n) because of we should do push-pop with temp, and then push pop with orig.
    // Time complexity O(2n) => O(n) - temp stack + orig stack size. 2 - because of null markers.
    // Great solution
    // https://discuss.leetcode.com/topic/54270/an-java-iterative-solution/2
    // https://discuss.leetcode.com/topic/54904/c-non-recursive-one-pass-solution-using-stack-a-possible-implementation-of-nestedinteger
    // https://discuss.leetcode.com/topic/54270/an-java-iterative-solution
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '[') {
                stack.push(null); // null is '[' marker
                index++;
            }
            else if (c == ']') {
                NestedInteger ni = new NestedInteger();
                Stack<NestedInteger> temp = new Stack<>(); // use one more stack to keep same order as original string has.
                while (stack.peek() != null) {
                    temp.push(stack.pop());
                }
                // remove '[' marker
                stack.pop();
                while (!temp.isEmpty()) {
                    ni.add(temp.pop());
                }
                // added newly created nested int;
                stack.push(ni);
                index++;
            } else if (Character.isDigit(c) || c == '-') {
                StringBuilder sb = new StringBuilder();
                while (index < s.length() && (Character.isDigit(s.charAt(index)) || s.charAt(index) == '-')) {
                    sb.append(s.charAt(index));
                    index++;
                }
                int i = Integer.parseInt(sb.toString());
                stack.push(new NestedInteger(i));
            } else { // if c == ','
                index++;
            }
        }
        return stack.pop();
    }
}