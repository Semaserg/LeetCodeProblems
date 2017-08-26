package LeetCode.heap.WaysToFormMaxHeap_intbit;

/*
Ways to form Max Heap
https://www.interviewbit.com/problems/ways-to-form-max-heap/

Max Heap is a special kind of complete binary tree in which for every node the value present in
that node is greater than the value present in it’s children nodes. If you want to know more about
 Heaps, please visit this link

So now the problem statement for this question is:

How many distinct Max Heap can be made from n distinct integers

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level,
except possibly the last, is completely filled, and all nodes are as far left as possible. )
Every node is greater than all its children
Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers

Following are the possible max heaps from these 4 numbers :

         4
       /  \
      3   2
     /
    1
         4
       /  \
      2   3
     /
    1
        4
       /  \
      3   1
     /
    2
These are the only possible 3 distinct max heaps possible for 4 distinct elements.

Implement the below function to return the number of distinct Max Heaps that is possible from n distinct elements.

As the final answer can be very large output your answer modulo 1000000007

Input Constraints : n <= 100

 NOTE: Note that even though constraints are mentioned for this problem, for most problems on InterviewBit, constraints
 are intentionally left out. In real interviews, the interviewer might not disclose
 constraints and ask you to do the best you can do.
*/

public class Solution {
    private final int modulo = 1000000007;
    private int sum;

    public int solve(int A) {
        if (A <=0) return 0;

        sum = 1;
        calc(A, 1);
        return sum;
    }

    private void calc(int curr, int prev) {
        if (curr == 0) return;

        int subTreesElements = curr - 1; // A-1 beacuse of root
        int rightSubTree = subTreesElements/2; // smaller
        int leftSubTree = subTreesElements - rightSubTree; // bigger

        if (leftSubTree > 1) {
            int leftSubTreeCombinations = combinations(subTreesElements, leftSubTree);
            add(leftSubTreeCombinations);

            calc(leftSubTree, leftSubTreeCombinations);
            calc(rightSubTree, leftSubTreeCombinations);
        }
    }

    private void add(int heapNums) {
        sum = (sum + heapNums) % modulo;
    }

    // number of possible combinations of r objects from a set of n objects
    // C = n!/(r!*(n-r)!)
    private int combinations(int n, int r) {
        return factorial(n) / (factorial(r)*factorial(n-r));
    }
    private int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
