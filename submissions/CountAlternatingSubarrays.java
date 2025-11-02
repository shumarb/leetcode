// Question: https://leetcode.com/problems/count-alternating-subarrays/description/

class CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        long[] dp = new long[n];
        long result = 0;

        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                dp[i] = 1 + dp[i - 1];
            }
        }
        for (long count: dp) {
            result += count;
        }
        if (isTest) {
            System.out.println("dp: " + Arrays.toString(dp) + "\nresult: " + result);
        }

        return result;
    }
}