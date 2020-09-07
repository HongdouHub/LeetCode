package leetcode.t355_Twitter;

import java.util.List;

@SuppressWarnings("all")
public interface ITwitter {

    /**
     * 创建一条新的推文
     */
    void postTweet(int userId, int tweetId);

    /**
     * 检索最近的十条推文。
     * 每个推文都必须是由此用户关注的人或者是用户自己发出的。
     * 推文必须按照时间顺序由最近的开始排序。
     */
    List<Integer> getNewsFeed(int userId);

    /**
     * 关注一个用户
     *
     * @param followerId 发起关注者 id
     * @param followeeId 被关注者 id
     */
    void follow(int followerId, int followeeId);

    /**
     * 取消关注一个用户
     *
     * @param followerId 发起关注者 id
     * @param followeeId 被关注者 id
     */
    void unfollow(int followerId, int followeeId);

}
