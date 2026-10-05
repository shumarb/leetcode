// Question: https://leetcode.com/problems/count-special-quadruplets/description/

class CountSpecialQuadruplets {
    public int countQuadruplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int result = 0;

        for (int c = 2; c < n - 1; c++) {
            for (int a = 0; a < c - 1; a++) {
                // 1. Store all possible nums[a] + nums[b] for range [0, n - 3],
                // where is in range [a + 1, c - 1].
                map.merge(nums[a] + nums[c - 1], 1, Integer::sum);
            }

            // 2. nums[a] + nums[b] == nums[d] - nums[c].
            for (int d = c + 1; d < n; d++) {
                int complement = nums[d] - nums[c];
                result += map.getOrDefault(complement, 0);
            }
        }

        return result;
    }
}
