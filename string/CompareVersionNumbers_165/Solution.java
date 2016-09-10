package LeetCode.string.CompareVersionNumbers_165;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
165. Compare Version Numbers
https://leetcode.com/problems/compare-version-numbers/

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth
second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/
public class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> arr1 = parse(version1);
        List<Integer> arr2 = parse(version2);
        int i=0, j=0;
        int a = 0, b = 0;
        while (i<arr1.size() || j<arr2.size()) {
            a = (i >= arr1.size()) ? 0 : arr1.get(i);
            b = (j >= arr2.size()) ? 0 : arr2.get(i);
            if (a > b) return 1;
            if (a < b) return -1;
            i++;
            j++;
        }
        return 0;
    }

    private List<Integer> parse(String version) {
        String[] arr = version.split("\\.");
        List<Integer> result = new ArrayList<>();
        for (String s : arr) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    // https://discuss.leetcode.com/topic/6238/accepted-small-java-solution
    public int compareVersion1(String version1, String version2) {
        String[] arr1 =  version1.split("\\.");
        String[] arr2 =  version2.split("\\.");
        int len = Math.max(arr1.length, arr2.length);

        for (int i=0; i<len; i++) {
            Integer v1 = (i >= arr1.length) ? 0 : Integer.parseInt(arr1[i]);
            Integer v2 =(i >= arr2.length) ? 0 : Integer.parseInt(arr2[i]);
            int compare = v1.compareTo(v2);
            if (compare != 0) return compare;
        }
        return 0;
    }
}