package LeetCode.string.IntegerToEnglishWords_273;

/*
273. Integer to English Words
https://leetcode.com/problems/integer-to-english-words/#/description

Total Accepted: 36515
Total Submissions: 167344
Difficulty: Hard
Contributor: LeetCode
Convert a non-negative integer to its english words representation.
Given input is guaranteed to be less than 231 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/
// https://discuss.leetcode.com/topic/23054/my-clean-java-solution-very-easy-to-understand
public class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int part = num % 1000;
            String strPart = helper(part);

            if (i > 0 && strPart.length() > 0) {
                result.insert(0, THOUSANDS[i] + " ");
            }
            result.insert(0, strPart);

            i++;
            num /= 1000;
        }
        return result.toString().trim();
    }

    private String helper(int part) {
        StringBuilder sb = new StringBuilder();
        int hundreds = part / 100;
        if (hundreds > 0) {
            sb.append(LESS_THAN_20[hundreds] + " Hundred ");
            part %= 100;
        }

        if (part > 0 && part < 20) {
            sb.append(LESS_THAN_20[part] + " ");
        } else {
            int tens = part / 10;
            if (tens > 0) {
                sb.append(TENS[tens] + " ");
                part %= 10;
            }

            if (part > 0) {
                sb.append(LESS_THAN_20[part] + " ");
            }
        }
        return sb.toString();
    }
}