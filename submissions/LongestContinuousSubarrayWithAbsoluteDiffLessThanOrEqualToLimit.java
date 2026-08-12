// Question: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean isTest = false;
        int left = 0;
        int result = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + ", limit: " + limit);
            System.out.println("------------------------------------------------------------");
        }
        for (int right = 0; right < nums.length; right++) {
            int incoming = nums[right];

            map.put(incoming, 1 + map.getOrDefault(incoming, 0));

            int maximum = map.lastKey();
            int minimum = map.firstKey();

            while (maximum - minimum > limit) {
                map.computeIfPresent(nums[left++], (key, count) -> count == 1 ? null : count - 1);
                maximum = map.lastKey();
                minimum = map.firstKey();
            }

            int length = right - left + 1;
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }

            result = Math.max(result, right - left + 1);
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
