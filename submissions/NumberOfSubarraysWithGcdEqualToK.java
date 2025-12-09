// Question: https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/description/

class NumberOfSubarraysWithGcdEqualToK {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int gcd = 0;
            for (int j = i; j < n; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == k) {
                    result++;
                } else if (gcd < k) {
                    break;
                }
            }
        }

        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}