// Question: https://leetcode.com/problems/count-number-of-bad-pairs/description/

class CountNumberOfBadPair {
    public long countBadPairs(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        boolean isTest = false;
        long n = nums.length;
        long goodPairs = 0;
        long totalPairs = n * (n - 1) / 2;

        for (long i = 0; i < n; i++) {
            long key = nums[(int) i] - i;
            goodPairs += map.getOrDefault(key, (long) 0);
            map.put(key, 1 + map.getOrDefault(key, (long) 0));
        }
        if (isTest) {
            System.out.println("map: " + map + "\ntotalPairs: " + totalPairs + "\ngoodPairs: " + goodPairs);
        }

        return totalPairs - goodPairs;
    }
}