package leetcode.t351_400.t355_Twitter;

import utils.GsonUtil;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        test1(new Twitter());
        test2(new Twitter());
    }

    /**
     * #postTweet(int userId, int tweetId)
     *
     * #getNewsFeed(int userId)
     *
     * #follow(int followerId, int followeeId)
     *
     * unfollow(int followerId, int followeeId)
     */

    private static void test1(ITwitter twitter) {
        twitter.postTweet(1, 1);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 4);
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 6);
        twitter.postTweet(1, 7);
        twitter.postTweet(1, 8);
        twitter.postTweet(1, 9);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 12);

        getNewsFeed(twitter, 1);

        twitter.follow(2, 1);
        getNewsFeed(twitter, 2);

        twitter.unfollow(2, 1);

        getNewsFeed(twitter, 2);
        System.out.println("-------------------------");
    }

    private static void test2(ITwitter twitter) {
        twitter.postTweet(1, 5);

        getNewsFeed(twitter, 1);

        twitter.follow(1, 2);

        twitter.postTweet(2, 6);

        getNewsFeed(twitter, 1);

        twitter.unfollow(1, 2);

        getNewsFeed(twitter, 1);
    }

    private static void getNewsFeed(ITwitter twitter, int userId) {
        List<Integer> res1 = twitter.getNewsFeed(userId);
        System.out.println(GsonUtil.array2Json(res1));
    }
}
