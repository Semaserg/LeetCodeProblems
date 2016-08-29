package LeetCode.array.ProductOfArrayExceptSelf_238;

/**

 238. Product of Array Except Self
 https://leetcode.com/problems/product-of-array-except-self/
 Given an array of n integers where n > 1, nums, return an array
 output such that output[i] is equal to the product of all the
 elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The
 output array does not count as extra space for the purpose of
 space complexity analysis.)
 */
public class Solution {
    // My stupid O(n) solution
    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        int zeros = 0;
        int firstZeroIndex = -1;
        int prod = 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                if (firstZeroIndex == -1) firstZeroIndex = i;
            } else {
                prod *= nums[i];
            }
        }
        if (zeros > 1) return res;
        if (zeros == 1) {
            res[firstZeroIndex] = prod;
            return res;
        }
        for (int j=0; j<nums.length; j++) {
            res[j] = prod/nums[j];
        }
        return res;
    }

    // Good solution with explanation
    // https://discuss.leetcode.com/topic/41177/my-one-pass-java-solution-without-extra-spaces
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i=0; i<len; i++) res[i] = 1;
        int left = 1;
        int right = 1;
        for (int i=0, j=len-1; i<len-1; i++, j-- ) {
            left *= nums[i];
            right *= nums[j];
            res[i+1] *= left;
            res[j-1] *= right;
        }
        return res;
    }
}