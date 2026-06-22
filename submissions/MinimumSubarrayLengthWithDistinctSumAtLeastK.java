// Question: https://leetcode.com/problems/minimum-subarray-length-with-distinct-sum-at-least-k/description/

class MinimumSubarrayLengthWithDistinctSumAtLeastK {
    public int minLength(int[] nums, int k) {
        boolean isTest = false;
        int[] count = new int[100001];
        int left = 0;
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        long sum = 0;

        if (n == 1) {
            return nums[0] >= k ? 1 : -1;
        }

        for (int right = 0; right < n; right++) {
            int incoming = nums[right];
            if (++count[incoming] == 1) {
                sum += incoming;
            }

            while (sum >= k) {
                result = Math.min(result, right - left + 1);
                if (isTest) {
                    System.out.println(" * valid | indices: [" + left + ", " + right
                            + "] | sum: " + sum + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
                }

                int remove = nums[left++];
                if (--count[remove] == 0) {
                    sum -= remove;
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
