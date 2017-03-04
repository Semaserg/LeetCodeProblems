package LeetCode.string.FizzBuzz_412;

import java.util.ArrayList;
import java.util.List;

/*
412. Fizz Buzz
https://leetcode.com/problems/fizz-buzz/?tab=Description

Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the
number and for the multiples of five output “Buzz”. For numbers which
are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/
public class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if (i%3 == 0 || i%5 == 0) {
                StringBuilder item = new StringBuilder();
                if (i%3 == 0) item.append("Fizz");
                if (i%5 == 0) item.append("Buzz");
                res.add(item.toString());
            } else {
                res.add(i+"");
            }
        }
        return res;
    }
}