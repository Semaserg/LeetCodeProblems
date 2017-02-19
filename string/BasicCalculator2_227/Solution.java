package LeetCode.string.BasicCalculator2_227;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
227. Basic Calculator II
https://leetcode.com/problems/basic-calculator-ii/

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/
public class Solution {
    // Time complexity O(n)
    //https://discuss.leetcode.com/topic/16935/share-my-java-solution
     public int calculate(String s) {
        s = s.replace(" ", "");
        int len = s.length();
        if (len==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        char sign = '+';
        for (int i=0; i<len; i++) {
            Character curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                currentNum = currentNum*10 + curr - '0';
            }
            if (!Character.isDigit(curr) || i==len-1){
                switch (sign) {
                    case '+' :
                        stack.push(currentNum);
                        break;
                    case '-' :
                        stack.push(-currentNum);
                        break;
                    case '*' :
                        stack.push(stack.pop()*currentNum);
                        break;
                    case '/' :
                        stack.push(stack.pop()/currentNum);
                        break;
                }
                sign = curr;
                currentNum=0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) result +=stack.pop();
        return result;
    }

    // my bad solution
    public int calculate1(String s) {
        if (s == null) return 0;
        s = s.trim().replaceAll(" ", "");
        if (s.length() == 0 ) return 0;
        Stack<String> stack = new Stack<>();
        List<String> tokenList = getTokens(s);
        for (String token : tokenList) {
            stack.push(token);
            if (shouldReduce(token)) {
                reduce(stack);
            }
        }
        reduce(stack);
        return Integer.parseInt(stack.pop());
    }

    private List<String> getTokens(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            Character current = s.charAt(i);
            if (Character.isDigit(current)) {
                sb.append(s.charAt(i));
            } else {
                // add int number
                list.add(sb.toString());
                // ad sign
                list.add(current.toString());
                // clear string builder for the next number.
                sb = new StringBuilder();
            }
        }
        if (sb.length()>0) list.add(sb.toString());
        return list;
    }

    private boolean shouldReduce(String token) {
        return token.equals("*") || token.equals("/");
    }

    private void reduce(Stack<String> stack) {
        while (stack.size()>=3){
            int right = Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int left = Integer.parseInt(stack.pop());
            Integer result = execute(left, right, sign);
            stack.push(result.toString());
        }
    }

    private Integer execute(int left, int right, String sign) {
        Character c = sign.charAt(0);
        switch (c) {
            case '+': return left+right;
            case '-': return left-right;
            case '/': return left/right;
            case '*': return left*right;
            default: throw new IllegalArgumentException("Unknown sign");
        }
    }
}