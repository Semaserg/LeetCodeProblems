package LeetCode.stack.DecodeString_394;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Stack;

/*
394. Decode String
https://leetcode.com/problems/decode-string/

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside
the square brackets is being repeated exactly k times. Note that k is
guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces,
 square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any
digits and that digits are only for those repeat numbers, k. For example,
there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
public class Solution {
    // recursive solution
    // https://discuss.leetcode.com/topic/57318/java-simple-recursive-solution
    // two stack solution
    // https://discuss.leetcode.com/topic/57159/simple-java-solution-using-stack
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int tempTimes = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                tempTimes = tempTimes*10 + (c - '0');
            } else if (c == '[') {
                stack.push(tempTimes + "");
                stack.push("[");
                tempTimes = 0;
            }
            else if (s.charAt(i) != ']') {
                stack.push(s.charAt(i) + "");
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // remove '['
                int times = Integer.parseInt(stack.pop());
                String str = sb.toString();
                StringBuilder part = new StringBuilder();
                for(int j=0; j<times; j++) {
                    part.append(str);
                }
                stack.push(part.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public String decodeString1(String s) {
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i) + "");
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // remove '['
                StringBuilder timesStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    timesStr.insert(0, stack.pop());
                }
                int times = Integer.parseInt(timesStr.toString());
                String str = sb.toString();
                StringBuilder part = new StringBuilder();
                for(int j=0; j<times; j++) {
                    part.append(str);
                }
                stack.push(part.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}