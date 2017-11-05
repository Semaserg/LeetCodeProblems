package LeetCode.binarySearch.Sqrt_69;

/**
https://leetcode.com/problems/sqrtx/#/description
69. Sqrt(x)
https://leetcode.com/problems/sqrtx/

Implement int sqrt(int x).
*/

// Great solution
// https://discuss.leetcode.com/topic/24532/3-4-short-lines-integer-newton-every-language
public class Solution {
    // Newton`s algorithm
    // https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division
    // https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%BD%D0%B0%D1%85%D0%BE%D0%B6%D0%B4%D0%B5%D0%BD%D0%B8%D1%8F_%D0%BA%D0%BE%D1%80%D0%BD%D1%8F_n-%D0%BD%D0%BE%D0%B9_%D1%81%D1%82%D0%B5%D0%BF%D0%B5%D0%BD%D0%B8
    // http://webhamster.ru/mytetrashare/index/mtb0/1684
    // https://discuss.leetcode.com/topic/24532/3-4-short-lines-integer-newton-every-language
    public int mySqrt1(int x) {
        long r = x;
        while(r*r > x) r = (r + x/r)/2;
        return (int)r;
    }

    // binary search
    // https://discuss.leetcode.com/topic/19698/my-clean-c-code-8ms
    // https://discuss.leetcode.com/topic/8680/a-binary-search-solution
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int lo = 1, hi = x;
        while(lo <= hi) { // important to use <= , for instance x == 1.
            int mid = lo + (hi - lo)/2;
            if (mid > x/mid) {
                hi = mid - 1;
            } else {
                if ((mid+1) > x/(mid+1)) return mid;
                lo = mid + 1;
            }
        }
        throw new IllegalStateException("ex");
    }
}