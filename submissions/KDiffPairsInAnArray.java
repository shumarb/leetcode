// Question: https://leetcode.com/problems/k-diff-pairs-in-an-array/description/

class KDiffPairsInAnArra {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int count = 0;

        for (int e: nums) {
            map.put(e, 1 + map.getOrDefault(e, 0));
        }

        for (int key: map.keySet()) {
            if (k == 0) {
                // 1. Count elements appearing more than once.
                if (map.get(key) > 1) {
                    if (isTest) {
                        System.out.println(" * pair: (" + key + ", " + key + ")");
                    }
                    count++;
                }
            } else {
                if (map.containsKey(key + k)) {
                    if (isTest) {
                        System.out.println(" * pair: (" + key + ", " + (k + key) + ")");
                    }
                    count++;
                }
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------");
            System.out.println("map: " + map + "\ncount: " + count);
        }
        return count;
    }
}