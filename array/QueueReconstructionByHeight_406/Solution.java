package LeetCode.array.QueueReconstructionByHeight_406;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

 406. Queue Reconstruction by Height
 https://leetcode.com/problems/queue-reconstruction-by-height/description/

 Suppose you have a random list of people standing in a queue. Each person is
 described by a pair of integers (h, k), where h is the height of the person
 and k is the number of people in front of this person who have a height greater
 than or equal to h. Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
class Solution {
    // https://discuss.leetcode.com/topic/60394/easy-concept-with-python-c-java-solution
    // https://discuss.leetcode.com/topic/60981/explanation-of-the-neat-sort-insert-solution
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return people;
        }
        int l = people.length;
        // tallest people first, in tallest group people with smaller k first
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1]-b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>(l);
        for (int[] p: people) {
            res.add(p[1], p);
        }
        for(int i=0; i<l; i++) people[i] = res.get(i);
        return people;
    }
}