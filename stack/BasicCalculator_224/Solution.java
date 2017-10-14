package LeetCode.stack.BasicCalculator_224;

import LeetCode.stack.BinaryTreeInorderTraversal_94.TreeNode;

import java.io.CharArrayReader;
import java.util.*;

/*
224. Basic Calculator
https://leetcode.com/problems/basic-calculator/description/

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ),
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

class Solution {
    // https://discuss.leetcode.com/topic/33044/java-easy-version-to-understand
    public int calculate(String s) {
        if (s == null) throw new IllegalArgumentException("ex");
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for (int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int next = 0;
                while (i<s.length() && Character.isDigit(s.charAt(i))) {
                    next = next * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                res += sign*next;
                i--;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int prevSign = stack.pop(), prevRes = stack.pop();
                res = prevRes + prevSign * res;
            }
        }
        return res;
    }
}