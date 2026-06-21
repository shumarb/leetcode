// Question: https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/description/

class MaximumSumOfAlmostUniqueSubarray class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.size();
        long sum = 0;
        long result = 0;

        for (int i = 0; i < k; i++) {
            sum += nums.get(i);
            map.put(nums.get(i), 1 + map.getOrDefault(nums.get(i), 0));
        }
        if (map.size() >= m) {
            result = sum;
        }

        for (int i = k; i < n; i++) {
            sum -= nums.get(i - k);
            map.put(nums.get(i - k), map.get(nums.get(i - k)) - 1);
            if (map.get(nums.get(i - k)) == 0) {
                map.remove(nums.get(i - k));
            }

            sum += nums.get(i);
            map.put(nums.get(i), 1 + map.getOrDefault(nums.get(i), 0));

            if (map.size() >= m) {
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
