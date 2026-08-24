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
            window.merge((long) nums[right], 1, Integer::sum);

            long maximum = window.lastKey();
            long minimum = window.firstKey();

            while ((maximum - minimum) * (right - left + 1) > k) {
                long remove = nums[left++];

                window.put(remove, window.get(remove) - 1);
                if (window.get(remove) == 0) {
                    window.remove(remove);
                }

                maximum = window.lastKey();
                minimum = window.firstKey();
            }
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + (right - left + 1) + " | window: " + window);
            }

            result += (right - left + 1);
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
