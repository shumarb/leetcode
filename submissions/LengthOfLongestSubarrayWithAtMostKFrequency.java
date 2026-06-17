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
            map.put(incoming, 1 + map.getOrDefault(incoming, 0));

            while (map.get(incoming) > k) {
                int remove = nums[left++];
                map.put(remove, map.get(remove) - 1);
            }
            if (isTest) {
                System.out.print(" * valid | indices: [" + left + ", " + right + "]");
                System.out.println(" | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)) + " | map: " + map);
            }

            result = Math.max(result, right - left + 1);
        }
        if (isTest) {
            System.out.println("--------------------------------\nresult: " + result);
        }

        return result;
    }
}
