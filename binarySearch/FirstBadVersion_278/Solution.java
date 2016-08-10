package LeetCode.binarySearch.FirstBadVersion_278;

/*
278. First Bad Version
https://leetcode.com/problems/first-bad-version/

You are a product manager and currently leading a team to develop a new product. Unfortunately,
the latest version of your product fails the quality check. Since each version is developed based
on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes
 all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls
to the API.
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution {
    /*Before this problem, I have always use
    mid = (start+end)) / 2;
    To get the middle value, but this can caused OVERFLOW !
    when start and end are all about INT_MAX , then (start+end) of course will be overflow !
    To avoid the problem we can use
    mid =  start+(end-start)/2;
    https://discuss.leetcode.com/topic/38135/a-good-warning-to-me-to-use-start-end-start-2-to-avoid-overflow
    */
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo<hi) {
            int mid = lo + (hi - lo)/2; // do not use (lo+hi)/2;
            if (isBadVersion(mid)) hi=mid;
            else lo=mid+1;
        }
        return lo;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}