// Question: https://leetcode.com/problems/design-twitter/description/

class Twitter {
    private Map<Integer, List<int[]>> users;
    private Map<Integer, Set<Integer>> followers;
    private int time;

    public Twitter() {
        followers = new HashMap<>();
        time = 0;
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new ArrayList<>());
        users.get(userId).add(new int[] {tweetId, time++});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<int[]> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int n = 10;

        list.addAll(users.getOrDefault(userId, new ArrayList<>()));
        if (followers.containsKey(userId)) {
            for (Integer followeeId: followers.get(userId)) {
                list.addAll(users.getOrDefault(followeeId, new ArrayList<>()));
            }
        }

        list.sort((a, b) -> Integer.compare(b[1], a[1]));
        n = Math.min(n, list.size());
        for (int i = 0; i < n; i++) {
            result.add(list.get(i)[0]);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId) && followers.get(followerId).contains(followeeId)) {
            followers.get(followerId).remove(followeeId);
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
