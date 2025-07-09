// Question: https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/description/

class LongestEvenOddSubarrayWithThreshold {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int len = nums.length;
        int longest = 0;

        for (int l = 0; l < len; ) {
            if (nums[l] <= threshold && nums[l] % 2 == 0) {
                int r = l + 1;
                while (r < len && nums[r] <= threshold && nums[r - 1] % 2 != nums[r] % 2) {
                    r++;
                }
                longest = Math.max(longest, r - l);
                l = r;

            } else {
                l++;
            }
        }

        return longest;
    }
}