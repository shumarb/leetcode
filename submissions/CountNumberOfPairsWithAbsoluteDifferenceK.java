// Question: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/

class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number: nums) {
            map.put(number, 1 + map.getOrDefault(number, 0));
        }

        for (int number: nums) {
            int complement = k + number;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
        }

        return count;
    }
}