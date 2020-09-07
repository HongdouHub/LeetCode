package leetcode.t355_Twitter;

import java.util.*;

/**
 * 355. 设计推特
 *
 * 设计一个简化版的推特(Twitter)，
 * 可以让用户实现发送推文，
 * 关注/取消关注其他用户，
 * 能够看见关注人（包括自己）的最近十条推文。
 *
 * 对于每个推特用户，我们需要存储他关注的用户 Id，以及自己发的推文 Id 的集合
 * 1) 用一个以用户 Id 为索引的哈希表来存储用户的信息
 * 2) 考虑对每个用户用链表存储发送的推文，链表头插入
 * 3) 操作2，等价于有若干个有序的链表，进行线性归并即可得到最近的十条推文
 *
 */
public class Twitter implements ITwitter {

    /**
     * 用户 id 和推文（单链表）的对应关系
     */
    private Map<Integer, Tweet> mTwitterMap;

    /**
     * 用户 id 和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> mFollowingsMap;

    /**
     * 合并 k 组推文使用的数据结构（可以在方法里创建使用），声明成全局变量非必需，视个人情况使用
     */
    private static PriorityQueue<Tweet> mMaxHeap;

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static volatile int mTimestamp = 0;

    public Twitter() {
        mTwitterMap = new HashMap<>();
        mFollowingsMap = new HashMap<>();
        mMaxHeap = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                // 降序排序
                return o2.timestamp - o1.timestamp;
            }
        });
    }

    @Override
    public void postTweet(int userId, int tweetId) {
        mTimestamp++;

        if (mTwitterMap.containsKey(userId)) {
            Tweet old = mTwitterMap.get(userId);
            Tweet tweet = new Tweet(tweetId, mTimestamp);
            tweet.next = old;
            mTwitterMap.put(userId, tweet);
        } else {
            mTwitterMap.put(userId, new Tweet(tweetId, mTimestamp));
        }
    }

    @Override
    public List<Integer> getNewsFeed(int userId) {
        mMaxHeap.clear();

        // 如果自己发了推文也要算上
        if (mTwitterMap.containsKey(userId)) {
            mMaxHeap.offer(mTwitterMap.get(userId));
        }

        Set<Integer> set = mFollowingsMap.get(userId);
        if (set != null && !set.isEmpty()) {
            for (Integer followUserId : set) {
                Tweet tweet = mTwitterMap.get(followUserId);
                if (tweet != null) {
                    mMaxHeap.offer(tweet);
                }
            }
        }

        List<Integer> result = new ArrayList<>(10);
        int count = 0;

        while (!mMaxHeap.isEmpty() && count < 10) {
            Tweet poll = mMaxHeap.poll();
            result.add(poll.id);

            if (poll.next != null) {
                mMaxHeap.offer(poll.next);
            }
            count++;
        }
        return result;
    }

    @Override
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        Set<Integer> set = mFollowingsMap.get(followerId);
        if (set == null) {
            set = new HashSet<>();
            set.add(followeeId);
            mFollowingsMap.put(followerId, set);
        } else {
            set.add(followeeId);
        }
    }

    @Override
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        Set<Integer> set = mFollowingsMap.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }
    }
}

class Tweet {
    /** 推文 id **/
    public int id;
    /** 发推文的时间戳 **/
    public int timestamp;
    /** 下一指针 **/
    public Tweet next;

    public Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}
