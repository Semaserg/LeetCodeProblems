package LeetCode.design.LoggerRateLimiter_359;

import java.util.HashMap;
import java.util.Map;

/*
359. Logger Rate Limiter
https://leetcode.com/problems/logger-rate-limiter/#/description

Design a logger system that receive stream of messages along with its timestamps,
each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if
 the message should be printed in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.

 */
// https://discuss.leetcode.com/topic/48615/a-solution-that-only-keeps-part-of-the-messages
public class Logger {
    private Map<String, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public Logger() {

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < map.getOrDefault(message, 0)) {
           return false;
        }
        map.put(message, timestamp+10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */