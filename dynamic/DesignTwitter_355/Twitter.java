package LeetCode.dynamic.DesignTwitter_355;


import javafx.util.Pair;

import java.util.*;

/**
355. Design Twitter
https://leetcode.com/problems/design-twitter/

Design a simplified version of Twitter where users can post tweets,
follow/unfollow another user and is able to see the 10 most recent
tweets in the user's news feed. Your design should support the
following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's
news feed. Each item in the news feed must be posted by users who the user
followed or by the user herself. Tweets must be ordered from most recent
to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
*/
// Good solution
// https://discuss.leetcode.com/topic/48100/java-oo-design-with-most-efficient-function-getnewsfeed

public class Twitter {

    private Map<Integer, Set<Integer>> followers; // key - followee, value - set of followers.
    private Map<Integer, Set<Tweet>> tweets;
    private Map<Integer, PriorityQueue<Tweet>> userNews;
    private int counter;

    class Tweet {
        int id;
        int time;
        int authorId;

        Tweet(int id, int time, int authorId) {
            this.id = id;
            this.time = time;
            this.authorId = authorId;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        counter = 0;
        followers = new HashMap<>();
        userNews = new HashMap<>();
        tweets = new HashMap<>();
    }

    private void initUser(int userId) {
        if (!followers.containsKey(userId)) {
            followers.put(userId, new HashSet<>());
            followers.get(userId).add(userId);
            userNews.put(userId, new PriorityQueue<>((a,b) -> b.time - a.time));
            tweets.put(userId, new HashSet<>());
        }
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        initUser(userId);
        Set<Integer> followersList = followers.get(userId);
        Tweet t = new Tweet(tweetId, ++counter, userId);
        tweets.get(userId).add(t);
        for(int f : followersList) {
            userNews.get(f).add(t);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        initUser(userId);
        ArrayList<Tweet> tweetsList = new ArrayList<>();
        ArrayList<Integer> tweetIds = new ArrayList<>();
        int size = Math.min(userNews.get(userId).size(), 10);
        for (int i=0; i<size; i++) {
            Tweet t = userNews.get(userId).poll();
            tweetsList.add(t);
            tweetIds.add(t.id);
        }
        for (Tweet t : tweetsList) {
            userNews.get(userId).add(t);
        }
        return tweetIds;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        initUser(followerId);
        initUser(followeeId);
        if (!followers.get(followeeId).contains(followerId)) {
            followers.get(followeeId).add(followerId);
            Set<Tweet> tweetList = tweets.get(followeeId);
            for(Tweet t : tweetList) {
                userNews.get(followerId).add(t);
            }
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        initUser(followerId);
        initUser(followeeId);
        if (followers.get(followeeId).contains(followerId) && followerId != followeeId) {
            followers.get(followeeId).remove(followerId);
            userNews.get(followerId).removeIf(t -> t.authorId == followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */