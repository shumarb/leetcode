// Question: https://leetcode.com/problems/random-pick-with-blacklist/description/

class RandomPickWithBlacklist {
    private Map<Integer, Integer> blacklistMap;
    private boolean isTest = false;
    private int whiteSize;

    public Solution(int n, int[] blacklist) {
        blacklistMap = new HashMap<>();
        whiteSize = n - blacklist.length;

        for (int number: blacklist) {
            blacklistMap.put(number, -1);
        }

        int last = n - 1;
        for (int number: blacklist) {
            if (number < whiteSize) {
                while (blacklistMap.containsKey(last)) {
                    last--;
                }
                blacklistMap.put(number, last);
                last--;
            }
        }

        if (isTest) {
            System.out.println("n: " + n + "\nblacklist: " + Arrays.toString(blacklist));
            System.out.println("blacklistMap: " + blacklistMap);
        }
    }

    public int pick() {
        int random = (int) (Math.random() * whiteSize);
        if (blacklistMap.containsKey(random)) {
            return blacklistMap.get(random);
        }
        return random;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */