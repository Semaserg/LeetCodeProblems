package LeetCode.stack.SimplifyPath_71;

import java.util.Stack;

/*
71. Simplify Path
https://leetcode.com/problems/simplify-path/

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/
public class Solution {
    // https://discuss.leetcode.com/topic/8678/c-10-lines-solution - same solution in 10 lines
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.trim().equals("")) {
                continue;
            }
            switch (token) {
                case ".":
                    break;
                case "..":
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(token);
                    break;
            }
        }
        if (stack.empty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}