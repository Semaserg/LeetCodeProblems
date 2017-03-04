package LeetCode.string.ImplementStrStr_28;

/*
28. Implement strStr()
https://leetcode.com/problems/implement-strstr/

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class Solution {
    // n - haystack length, m - needle length;
    // Time complexity O(n*m) space complexity just for init data - O(n*m)
    public int strStr1(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if (needleLen>haystackLen) return -1;
        if (needleLen==0) return 0;
        Character nFirst = needle.charAt(0);
        for (int i=0; i<haystack.length(); i++) {
            if (haystack.charAt(i) == nFirst) {
                if (needleLen == 1) return i;
                boolean found = true;
                for (int j=1; j<needleLen; j++) {
                    if (i+j>=haystackLen || haystack.charAt(i+j) != needle.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) return i;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int mPointer = 0;
        int nPointer = 0;
        if (n == 0) return 0;
        while (mPointer < m && nPointer < n) {
            int lastStart = mPointer;
            while (mPointer < m && nPointer < n && haystack.charAt(mPointer) == needle.charAt(nPointer)) {
                mPointer++;
                nPointer++;
            }
            if (nPointer == n) return lastStart;
            else {
                mPointer = lastStart+1;
                nPointer = 0;
            }
        }
        return -1;
    }
}