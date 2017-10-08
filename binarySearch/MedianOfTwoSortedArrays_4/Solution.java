package LeetCode.binarySearch.MedianOfTwoSortedArrays_4;

/*
4. Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/description/

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

// https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation
// conditions
// i - index in A (0..m), A[i-1] <= A[i]
// j - index in B, (0..n), B[j-1] <= B[j]
// Num Of elements in left part (A[0..i-1] + B[0..j-1]) == num el in right part (A[i..m-1] + B[j..n-1])
// So, left part size == right part size == i + j == m-i + n-j == (m+n+1)/2. Why +1 - if m==3, n==4, 3+4 == 7, 7/2 == 3
// but we need two parts which are equal or intersect in 1 el, should be 4, so (3+4+1)/2 == 4.
// MEDIAN IS:
// m+n odd: Max(left part)
// - i==0 B[j-1],
// - j==0 A[i-1]
// else - Max.max(A[i-1], B[j-1])
// m+n even:
// (Max(left_part) + Min(left_part))/2
//
// i + j == m - i + n - j + 1 => 2j == m + n - 2i + 1 => j == (m+n+1)/2 - i
// To ensure these two conditions, we just need to ensure:
//
// (1) i + j == m - i + n - j (or: m - i + n - j + 1)
// if n >= m, we just need to set: i = 0 ~ m, j = (m + n + 1)/2 - i
//    (2) B[j-1] <= A[i] and A[i-1] <= B[j] !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) throw new IllegalArgumentException("ex");
        if (nums1.length == 0 && nums2.length == 0) throw new IllegalArgumentException("ex");
        if (nums1.length == 0) return getMadian(nums2);
        if (nums2.length == 0) return getMadian(nums1);

        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int[] A = nums1, B = nums2;
        int half = (m + n + 1)/2; // so j == half - i
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = iMin + (iMax - iMin)/2;
            int j = half - i;
            if (i < m && B[j-1] > A[i] ) { //should be B[j-1] <= A[i], if B[j-1]>A[i] => i is too small
                iMin = i + 1;
            } else if (i > 0 && A[i-1] > B[j]) {// should be  A[i-1] <= B[j], if  A[i-1] > B[j] => i is too big
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) maxLeft = B[j-1];
                else if (j == 0) maxLeft = A[i-1];
                else maxLeft = Math.max(A[i-1], B[j-1]);

                if ((n+m)%2 == 1) return maxLeft;

                int minRight = 0;
                if (i == m) minRight = B[j];
                else if (j == n) minRight = A[i];
                else minRight = Math.min(A[i], B[j]);

                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }

    public double getMadian(int[] nums) {
        return (nums.length%2) == 1 ? nums[nums.length/2] : (nums[nums.length/2] + nums[nums.length/2 - 1])/2.0;
    }
}