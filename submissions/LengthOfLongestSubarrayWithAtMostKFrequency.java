// Question: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/

class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int left = 0;
        int n = nums.length;
        int result = 0;

        if (n == 1) {
            return 1;
        }

        for (int right = 0; right < n; right++) {
            int incoming = nums[right];
            map.merge(incoming, 1, Integer::sum);

            while (map.get(incoming) > k) {
                map.computeIfPresent(nums[left++], (key, count) -> count == 1 ? null : count - 1);
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * length: " + length + " | indices: [" + left + ", " + right + "] | map: " + map + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }

            result = Math.max(length, result);
        }

        return result;
    }
}
