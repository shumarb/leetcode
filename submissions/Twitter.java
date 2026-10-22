// Question: https://leetcode.com/problems/design-twitter/description/

class Twitter {
    private Map<Integer, List<Pair>> users;
    private Map<Integer, Set<Integer>> followers;
    private boolean isTest;
    private int time;

    public Twitter() {
        followers = new HashMap<>();
        isTest = false;
        time = 0;
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (isTest) {
            System.out.println("postTweet | userId: " + userId + " | tweetId: " + tweetId);
            print("\nbefore:");
        }

        users.putIfAbsent(userId, new ArrayList<>());
        users.get(userId).add(new Pair(time++, tweetId));

        if (isTest) {
            print("\nafter:");
            System.out.println("--------------------------------------------------");
        }
    }

    private void print(String s) {
        System.out.println(s + "\n - users:");

        for (Integer key: users.keySet()) {
            System.out.println("  * " + key + ":");
            for (Pair e: users.get(key)) {
                System.out.println("   ** [tweetId: " + e.tweetId + ", time: " + e.time + "]");
            }
            System.out.println();
        }

        System.out.println(" - followers:");
        for (Integer key: followers.keySet()) {
            System.out.println("  * " + key + ": " + followers.get(key));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Pair> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int n = 10;

        if (isTest) {
            System.out.println("getNewsFeed | userId: " + userId);
        }

        list.addAll(users.getOrDefault(userId, new ArrayList<>()));
        if (followers.containsKey(userId)) {
            for (Integer followeeId: followers.get(userId)) {
                list.addAll(users.getOrDefault(followeeId, new ArrayList<>()));
            }
        }

        list.sort((a, b) -> Integer.compare(b.time, a.time));
        n = Math.min(n, list.size());
        for (int i = 0; i < n; i++) {
            result.add(list.get(i).tweetId);
        }
        if (isTest) {
            System.out.println("\nlist:");
            for (Pair e: list) {
                System.out.println(" * [tweetId: " + e.tweetId + ", time: " + e.time + "]");
            }
            System.out.println("\nresult: " + result + "\n--------------------------------------------------");
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (isTest) {
            System.out.println("follow | followerId: " + followerId + " | followeeId: " + followeeId);
            print("\nbefore:");
        }

        if (followerId == followeeId) {
            return;
        }

        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);

        if (isTest) {
            print("\nafter:");
            System.out.println("--------------------------------------------------");
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (isTest) {
            System.out.println("unfollow | followerId: " + followerId + " | followeeId: " + followeeId);
            print("\nbefore:");
        }

        if (followers.containsKey(followerId) && followers.get(followerId).contains(followeeId)) {
            followers.get(followerId).remove(followeeId);
        }

        if (isTest) {
            print("\nafter:");
            System.out.println("--------------------------------------------------");
        }
    }
}

class Pair {
    int time;
    int tweetId;

    public Pair(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
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
