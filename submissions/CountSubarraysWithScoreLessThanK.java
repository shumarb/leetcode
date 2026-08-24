// Question: https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/

class CountSubarraysWithScoreLessThanK {
    public long countSubarrays(int[] nums, long k) {
        boolean isTest = false;
        int left = 0;
        long result = 0;
        long sum = 0;

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums));
            System.out.println("--------------------------------------------------------------------------------");
        }
        for (int right = 0; right < nums.length; right++) {
            long length = right - left + 1;
            sum += nums[right];

            while (sum * length >= k) {
                sum -= nums[left++];
                length--;
            }
            if (isTest) {
                System.out.println(" * indices: [" + left + ", " + right + "] | length: " + length + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
            }

            result += length;
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
