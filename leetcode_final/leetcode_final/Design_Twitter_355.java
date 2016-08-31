package leetcode_final;

import java.util.*;

/**
 * Created by Xuehj on 16/7/14.
 */
public class Design_Twitter_355 {
}

class Twitter_2 {
    private static int timeStamp=0;

    // easy to find if user exist
    private Map<Integer, User> userMap;

    // Tweet link to next Tweet so that we can save a lot of time
    // when we execute getNewsFeed(userId)
    private class Tweet{
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            time = timeStamp++;
            next=null;
        }
    }


    // OO design so User can follow, unfollow and post itself
    public class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id){
            this.id=id;
            followed = new HashSet<>();
            follow(id); // first follow itself
            tweet_head = null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }


        // everytime user post a new tweet, add it to the head of tweet list.
        public void post(int id){
            Tweet t = new Tweet(id);
            t.next=tweet_head;
            tweet_head=t;
        }
    }




    /** Initialize your data structure here. */
    public Twitter_2() {
        userMap = new HashMap<Integer, User>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);

    }



    // Best part of this.
    // first get all tweets lists from one user including itself and all people it followed.
    // Second add all heads into a max heap. Every time we poll a tweet with
    // largest time stamp from the heap, then we add its next tweet into the heap.
    // So after adding all heads we only need to add 9 tweets at most into this
    // heap before we get the 10 most recent tweet.
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if(!userMap.containsKey(userId))   return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a, b)->(b.time-a.time));
        for(int user: users){
            Tweet t = userMap.get(user).tweet_head;
            // very imporant! If we add null to the head we are screwed.
            if(t!=null){
                q.add(t);
            }
        }
        int n=0;
        while(!q.isEmpty() && n<10){
            Tweet t = q.poll();
            res.add(t.id);
            n++;
            if(t.next!=null)
                q.add(t.next);
        }

        return res;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
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






/////////////////////////////////////////////////////
class Post{
    int post_id;
    int time_stamp;
    Post(int x,int y){
        post_id=x;
        time_stamp=y;
    }
}


class Twitter {

    int time;
    HashMap<Integer,ArrayList<Post>> user_map_post;
    HashMap<Integer,ArrayList<Integer>> user_map_follow;

    /** Initialize your data structure here. */
    public Twitter() {
        time = 1;
        user_map_follow = new HashMap<>();
        user_map_post = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Post p = new Post(tweetId,time++);
        ArrayList<Post> post_s = user_map_post.get(userId);
        if(post_s==null)
            post_s = new ArrayList<>();
        post_s.add(p);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> all_users = new ArrayList<>();
        all_users.add(userId);
        if(user_map_follow.get(userId)!=null)
            all_users.addAll(user_map_follow.get(userId));

        List<Integer> res = new ArrayList<>();
        int start_time = 0;
        for(int i=0;i<10;i++){
            int small_est_uid = -1;
            int small_est_index = -1;
            int small_gap =99999;

            for(int uid_index=0;uid_index<all_users.size();uid_index++){

                ArrayList<Post> all_posts = user_map_post.get(all_users.get(uid_index));
                if(all_posts==null)
                    continue;
                for(int j=0;j<all_posts.size();j++){
                    Post one_post = all_posts.get(j);
                    if(one_post.time_stamp<start_time) {
                        continue;
                    }else {
                        if(one_post.time_stamp-start_time<small_gap){
                            small_gap = one_post.time_stamp-start_time;
                            small_est_index = j;
                            small_est_uid = uid_index;

                        }else {
                            break;
                        }
                    }
                }
            }

            if(small_est_index==-1)
                break;

            Post  this_post =  user_map_post.get(all_users.get(small_est_uid)).get(small_est_index);
            start_time = this_post.time_stamp;
            res.add(this_post.post_id);
        }

        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        ArrayList<Integer> follow = user_map_follow.get(followerId);
        if(follow==null)
            follow = new ArrayList<>();
        follow.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        ArrayList<Integer> follow = user_map_follow.get(followerId);
        if(follow!=null)
            follow.remove((Integer) followeeId);
    }
}