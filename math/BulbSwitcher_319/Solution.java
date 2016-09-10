package LeetCode.math.BulbSwitcher_319;

/*
319. Bulb Switcher
https://leetcode.com/problems/bulb-switcher/

 There are n bulbs that are initially off. You first turn on all the bulbs.
 Then, you turn off every second bulb. On the third round, you toggle every
 third bulb (turning on if it's off or turning off if it's on). For the ith
 round, you toggle every i bulb. For the nth round, you only toggle the last
 bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3.

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off].

So you should return 1, because there is only one bulb is on.
*/
public class Solution {
    // My stupid solution, Time limit excided.
    public int bulbSwitch1(int n) {
        if (n == 0) return 0;
        boolean[] bulbs = new boolean[n];
        int step = 1;
        for (int round=1; round<=n; round++) {
            for (int buldId=step-1; buldId<n; buldId+=step) {
                bulbs[buldId] = !bulbs[buldId];
            }
            step++;
        }
        int count = 0;
        for (int i=0; i<n; i++) {
            if (bulbs[i]) count++;
        }
        return count;
    }

    // step 0: all bulbs are off
    // step 1: all bulbs are on => toggle from the 0 index
    // step 2: toggle every 2nd bulb starting from 1 index => 0 is done, [1..n] toggled every 2nd
    // ...
    // step n: [0.. n-2] are done, toggle bulb[n-1] - last one.
    // Good explanation
    // https://discuss.leetcode.com/topic/39558/share-my-o-1-solution-with-explanation
    public int bulbSwitch(int n) {
        return (int)Math.sqrt((double)n);
    }
}
