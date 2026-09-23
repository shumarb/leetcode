// Question: https://leetcode.com/problems/longest-harmonious-subsequence/description/

class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int e: nums) {
            map.merge(e, 1, Integer::sum);
        }
        for (int key: map.keySet()) {
            int next = key + 1;
            if (map.containsKey(next)) {
                result = Math.max(map.get(key) + map.get(next), result);
            }
        }

        return result;
    }
}
