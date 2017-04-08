package LeetCode.array.SearchForARange_34;

/**
 34. Search for a Range
 https://leetcode.com/problems/search-for-a-range/

 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class Solution {

    // O(n) solution because of two inner whiles.
    public int[] searchRange1(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums.length==0) return res;
        int left = 0;
        int right = nums.length-1;
        while (left<=right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                int i=mid;
                while (i>=0 && nums[i]==target) i--;
                int j=mid;
                while (j<=nums.length-1 && nums[j]==target) j++;
                res[0]=i+1;
                res[1]=j-1;
                return res;
            }else if (mid>target) {
                right = mid-1;
            }else if (mid<target) {
                left=mid+1;
            }
        }
        return res;
    }

    //https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation
    // use binary search two times for upper and lower bound.
    // https://discuss.leetcode.com/topic/6327/a-very-simple-java-solution-with-only-one-binary-search-algorithm
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums.length==0) return res;
        int left = 0;
        int right = nums.length-1;
        // nums = {5,7,7,8,8,8,9,9,10};
        // left=right=3
        while (left<right) {
            int mid = (left+right)/2;
            if (nums[mid]<target) left = mid+1;
            else right=mid;
        }

        if (nums[right] != target) return res;
        // if we have only 1 element in array == target, this case will be caught here
        else res[0] = left; //left == right so we can use any of them

        left = right;
        right = nums.length-1;

        // nums = {5,7,7,8,8,8,9,9,10};
        // left=right=5
        while (left<right) {
            int mid = ((left+right)/2) + 1;
            if (nums[mid]>target) right = mid-1;
            else left=mid;
        }
        res[1] = left; //left == right so we can use any of them
        return res;
    }
}