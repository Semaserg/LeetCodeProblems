package LeetCode.dynamic.ExpressionAddOperators_282;


import java.util.ArrayList;
import java.util.List;

/*
282. Expression Add Operators
https://leetcode.com/problems/expression-add-operators/description/

Given a string that contains only digits 0-9 and a target value,
return all possibilities to add binary operators (not unary)
+, -, or * between the digits so they evaluate to the target value.

Examples:
"123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/
// https://discuss.leetcode.com/topic/24523/java-standard-backtrace-ac-solutoin-short-and-clear
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> results = new ArrayList<>();
        if (num == null || num.isEmpty()) return results;
        helper(results, "", num, target, 0, 0, 0);
        return results;
    }

    private void helper(List<String> results, String expression, String num, int target, int position, long curr, long multiplied) {
        if (position == num.length()) {
            if (curr == target) {
                results.add(expression);
            }
            return;
        }
        for (int i=position; i<num.length(); i++) {
            if(i != position && num.charAt(position) == '0') break;
            long nextNumber = Long.parseLong(num.substring(position, i+1));
            if (position == 0) {
                helper(results, expression + nextNumber, num, target, i+1, nextNumber, nextNumber);
            } else {
                helper(results, expression + "+" + nextNumber, num, target, i+1, curr+nextNumber, nextNumber);
                helper(results, expression + "-" + nextNumber, num, target, i+1, curr-nextNumber, -nextNumber);
                helper(results, expression + "*" + nextNumber, num, target, i+1,
                        curr-multiplied+multiplied*nextNumber, multiplied*nextNumber);
            }
        }
    }
}