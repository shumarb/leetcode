// Question: https://leetcode.com/problems/count-subarrays-with-cost-less-than-or-equal-to-k/description/

class CountSubarraysWithCostLessThanOrEqualToK {
    public long countSubarrays(int[] nums, long k) {
        TreeMap<Long, Integer> window = new TreeMap<>();
        boolean isTest = false;
        int left = 0;
        long result = 0;

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums) + "\n-----------------------------------------------------------");
        }
        for (int right = 0; right < nums.length; right++) {
            long length = right - left + 1;
            window.merge((long) nums[right], 1, Integer::sum);

            while ((window.lastKey() - window.firstKey()) * length > k) {
                window.computeIfPresent((long) nums[left++], (key, value) -> value == 1 ? null : value - 1);
                length--;
            }
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | window: " + window);
            }

            result += length;
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
