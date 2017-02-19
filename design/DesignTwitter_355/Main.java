package LeetCode.design.DesignTwitter_355;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1,5);
        List<Integer> news1 = obj.getNewsFeed(1);
        obj.follow(1,2);
        obj.postTweet(2,6);
        List<Integer> news2 = obj.getNewsFeed(1);
        obj.unfollow(1,2);
        List<Integer> news3 = obj.getNewsFeed(1);
        System.out.print(news1);
        System.out.print(news2);
        System.out.print(news3);
    }
}


//["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
//        [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
//["Twitter","postTweet","unfollow","getNewsFeed"]
//        [[],[1,5],[1,1],[1]]