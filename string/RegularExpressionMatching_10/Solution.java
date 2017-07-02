package LeetCode.string.RegularExpressionMatching_10;

import java.util.HashMap;

/*
https://leetcode.com/problems/regular-expression-matching/#/destrCharription
10. Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
public class Solution {
    // Time Limit Exceeded
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) throw new IllegalArgumentException("ex");
        if (p.length() == 0) return s.length() == 0;

        return helper(s, 0, p, 0);
    }

    private boolean helper(String s, int sIndex, String p, int pIndex) {
        if (sIndex == s.length() && pIndex == p.length()) return true;
        if (pIndex == p.length() && sIndex != s.length()) {
            System.out.println("pattern is over fail: sIndex=" + sIndex);
            return false; // string is not over but pattern is over
        }
        if (pIndex != p.length() && sIndex == s.length()) { // string is over but pattern is not
            return restOfPatternMatchEmptyString(p, pIndex);
        }

        char strChar = s.charAt(sIndex);
        char patternChar = p.charAt(pIndex);

        if (isStar(p, pIndex)) {
            if (patternChar == '.') patternChar = strChar; // .*
            if (patternChar != strChar) { // no matches for x* pattern, keep going
                return helper(s, sIndex, p, pIndex+2);
            } else {
                if (helper(s, sIndex, p, pIndex+2)) return true;
                while (patternChar == strChar) { // run x* pattern check for each position in string where pattern char equals strung char
                    boolean isValidCurrPattern = helper(s, sIndex + 1, p, pIndex); // check *x pattern for next pos
                    boolean isValidNextPattern = helper(s, sIndex + 1, p, pIndex + 2); // check next pattern for next pos
                    if (isValidCurrPattern || isValidNextPattern) return true;

                    sIndex++;
                    if (sIndex == s.length()) break;
                    else strChar = s.charAt(sIndex);
                }
            }
        } else if (patternChar == '.' || patternChar == strChar) {
            return helper(s, sIndex+1, p, pIndex+1);
        }
        System.out.println("no match fail: patternChar=" + patternChar + "; strChar=" + strChar);
        return false;
    }

    private boolean isStar(String p, int pIndex) {
        return pIndex <= p.length()-2 && p.charAt(pIndex+1) == '*';
    }

    private boolean restOfPatternMatchEmptyString(String p, int pIndex) {
        while (pIndex < p.length()) {
            if (isStar(p, pIndex)) pIndex +=2;
            else  {
                System.out.println("restOfPatternMatchEmptyString fail: pIndex=" + pIndex);
                return false;
            }
        }
        return true;
    }
}