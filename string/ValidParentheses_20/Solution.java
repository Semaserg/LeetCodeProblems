package LeetCode.string.ValidParentheses_20;

import java.util.Stack;

/*
20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Solution {
    // time, space complexity O(n)
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< s.length(); i++) {
            Character curr = s.charAt(i);
            if (isOpen(curr)) stack.push(curr);
            else if (isClose(curr)) {
                if (stack.isEmpty()) return false;
                Character prev = stack.pop();
                if (!isMatch(prev, curr)) return false;
            } else {
                throw new IllegalArgumentException("Unexpected character");
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpen(Character c) {
        return c=='{' || c=='[' || c=='(';
    }

    private boolean isClose(Character c) {
        return c=='}' || c==']' || c==')';
    }

    private boolean isMatch(Character open, Character close)
    {
        return (open=='{' && close=='}') || (open=='[' && close==']') || (open=='(' && close==')');
    }
}